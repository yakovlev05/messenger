package ru.yakovlev05.school.flash.service.impl;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import ru.yakovlev05.school.flash.entity.RefreshToken;
import ru.yakovlev05.school.flash.entity.User;
import ru.yakovlev05.school.flash.exception.NotFoundException;
import ru.yakovlev05.school.flash.repository.RefreshTokenRepository;
import ru.yakovlev05.school.flash.service.RefreshTokenService;

import java.util.Date;

@RequiredArgsConstructor
@Service
public class RefreshTokenServiceImpl implements RefreshTokenService {

    private final RefreshTokenRepository refreshTokenRepository;

    @Override
    public void save(RefreshToken refreshTokenEntity) {
        refreshTokenRepository.save(refreshTokenEntity);
    }

    @Override
    public RefreshToken getByToken(String refreshToken) {
        return refreshTokenRepository.findByToken(refreshToken)
                .orElseThrow(() -> new NotFoundException("Refresh token '%s' не найден", refreshToken));
    }

    @Override
    public void delete(RefreshToken refreshToken) {
        refreshTokenRepository.delete(refreshToken);
    }

    @Override
    public void save(String refreshToken, User user, Date expiredAt) {
        RefreshToken refreshTokenEntity = new RefreshToken();
        refreshTokenEntity.setToken(refreshToken);
        refreshTokenEntity.setUser(user);
        refreshTokenEntity.setExpiredAt(expiredAt);

        refreshTokenRepository.save(refreshTokenEntity);
    }

    @Override
    public void revokeAllTokens(Long userId) {
        refreshTokenRepository.removeAllByUser_Id(userId);
    }
}
