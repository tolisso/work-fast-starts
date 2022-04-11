package ru.diasoft.micro.service;

import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Service;
import ru.diasoft.micro.domain.*;
import ru.diasoft.micro.repository.SmsVerificationRepository;

import java.util.Optional;
import java.util.Random;
import java.util.UUID;

@RequiredArgsConstructor
@Service
@Primary
public class SmsVerificationPrimaryService implements SmsVerificationService {

    private final SmsVerificationRepository repository;

    @Override
    public SmsVerificationCheckResponse dsSmsVerificationCheck(SmsVerificationCheckRequest smsVerificationCheckRequest) {
        Optional<SmsVerification> smsOpt = repository.findBySecretCodeAndProcessGuid(smsVerificationCheckRequest.getCode(), smsVerificationCheckRequest.getProcessGUID());
        boolean statusBool = smsOpt.map(sms -> "OK".equals(sms.getStatus())).orElse(false);
        return new SmsVerificationCheckResponse(statusBool);
    }

    @Override
    public SmsVerificationPostResponse dsSmsVerificationCreate(SmsVerificationPostRequest smsVerificationPostRequest) {
        SmsVerification smsVerification = new SmsVerification();
        smsVerification.setPhoneNumber(smsVerificationPostRequest.getPhoneNumber());
        smsVerification.setProcessGuid(UUID.randomUUID().toString());
        smsVerification.setSecretCode(String.format("%05d", new Random().nextInt(100000)));
        smsVerification.setStatus("WAIT");

        repository.save(smsVerification);

        return new SmsVerificationPostResponse(smsVerification.getProcessGuid());
    }
}
