package ru.diasoft.micro.service;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.junit4.SpringRunner;
import ru.diasoft.micro.domain.*;
import ru.diasoft.micro.repository.SmsVerificationRepository;

import java.util.Optional;
import java.util.UUID;

import static org.mockito.Mockito.when;

@RunWith(SpringRunner.class)
@SpringBootTest
@ActiveProfiles("test")
public class SmsVerificationServiceTest {

    @Mock
    private SmsVerificationRepository repository;

    private SmsVerificationPrimaryService service;


    private final String PHONE_NUMBER = "88005553535";
    private final String VALID_SECRET_CODE = "12345";
    private final String INVALID_SECRET_CODE = "54321";
    private final String GUID = UUID.randomUUID().toString();
    private final String STATUS = "OK";

    @Before
    public void init(){
        service = new SmsVerificationPrimaryService(repository);

        SmsVerification smsVerification = SmsVerification.builder()
            .processGuid(GUID)
            .phoneNumber(PHONE_NUMBER)
            .secretCode(VALID_SECRET_CODE)
            .status(STATUS)
            .build();

        when(repository.findBySecretCodeAndProcessGuid(INVALID_SECRET_CODE, GUID))
                .thenReturn(Optional.empty());
        when(repository.findBySecretCodeAndProcessGuid(VALID_SECRET_CODE, GUID))
            .thenReturn(Optional.of(smsVerification));
    }

    @Test
    public void testDsSmsVerificationCreate_OK() {
        SmsVerificationPostResponse response =
                service.dsSmsVerificationCreate(new SmsVerificationPostRequest(PHONE_NUMBER));
        Assert.assertNotNull(response.getProcessGUID());
    }

    @Test
    public void testDsSmsVerificationCheck_OK() {
        SmsVerificationCheckResponse getResponse =
                service.dsSmsVerificationCheck(new SmsVerificationCheckRequest(GUID, VALID_SECRET_CODE));
        Assert.assertTrue(getResponse.getCheckResult());

    }

    @Test
    public void testDsSmsVerificationCheck_FAULT() {
        SmsVerificationCheckResponse getResponse =
                service.dsSmsVerificationCheck(new SmsVerificationCheckRequest(GUID, INVALID_SECRET_CODE));
        Assert.assertFalse(getResponse.getCheckResult());

    }

}
