package ru.diasoft.micro.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import ru.diasoft.micro.domain.SmsVerification;

import java.util.Optional;

@Repository
public interface SmsVerificationRepository extends JpaRepository<SmsVerification, Long> {
    Optional<SmsVerification> findBySecretCodeAndProcessGuid(String secretCode, String processGuid);

    @Modifying
    @Query("update SmsVerification v set status = ?2 where processguid = ?1")
    void updateStatusByGuid(String guid, String status);

}
