package structure.java22.api.feature.usermanagement.service;

import jakarta.transaction.Transactional;
import lombok.AllArgsConstructor;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import structure.java22.api.common.CommonResponse;
import structure.java22.api.common.ErrorCode;
import structure.java22.api.entity.ButtonEntity;
import structure.java22.api.entity.UserEntity;
import structure.java22.api.exception.HandleException;
import structure.java22.api.feature.usermanagement.dto.ButtonDTO;
import structure.java22.api.feature.usermanagement.dto.UserDTO;
import structure.java22.api.feature.usermanagement.serviceinterface.ButtonServiceInterface;
import structure.java22.api.feature.usermanagement.serviceinterface.UserServiceInterface;
import structure.java22.api.repository.ButtonRepository;
import structure.java22.api.repository.UserRepository;


@Service
@AllArgsConstructor
public class ButtonService implements ButtonServiceInterface {

    private final ButtonRepository buttonRepository;

    @Override
    @Transactional
    public CommonResponse<Object> findAllButton() {
        CommonResponse<Object> response = new CommonResponse<>();
        response.setData(buttonRepository.findAll());
        return response;
    }

    @Override
    @Transactional
    public CommonResponse<Object> create(ButtonDTO.RequestCreate req) {
        CommonResponse<Object> response = new CommonResponse<>();
        ButtonEntity buttonEntity = new ButtonEntity();
        buttonEntity.setAction(req.getAction());
        buttonEntity.setFontColor(req.getFontColor());
        buttonEntity.setButtonColor(req.getButtonColor());
        buttonEntity.setBorderRadius(req.getBorderRadius());
        buttonEntity.setButtonText(req.getButtonText());
        buttonEntity.setButtonDetails(req.getButtonDetails());
        buttonEntity.setIcon(req.getIcon());
        buttonEntity.setIconColor(req.getIconColor());
        buttonRepository.save(buttonEntity);
        return response;
    }

    @Override
    public CommonResponse<Object> update(ButtonDTO.RequestCreate req) {
        CommonResponse<Object> response = new CommonResponse<>();
        ButtonEntity buttonEntity = buttonRepository.findById(req.getButtonId()).orElseThrow(() -> new HandleException(ErrorCode.DATA_NOT_FOUND_IN_ID));
        buttonEntity.setAction(req.getAction());
        buttonEntity.setFontColor(req.getFontColor());
        buttonEntity.setButtonColor(req.getButtonColor());
        buttonEntity.setBorderRadius(req.getBorderRadius());
        buttonEntity.setButtonText(req.getButtonText());
        buttonEntity.setButtonDetails(req.getButtonDetails());
        buttonEntity.setIcon(req.getIcon());
        buttonEntity.setIconColor(req.getIconColor());
        buttonRepository.save(buttonEntity);
        return response;
    }
}

