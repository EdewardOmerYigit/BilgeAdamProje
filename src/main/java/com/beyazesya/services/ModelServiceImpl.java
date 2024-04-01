package com.beyazesya.services;

import com.beyazesya.dto.model.ModelDTO;
import com.beyazesya.dto.model.ModelSaveDTO;
import com.beyazesya.dto.model.ModelUpdateDTO;
import com.beyazesya.entities.Model;
import com.beyazesya.repository.ModelRepository;
import lombok.RequiredArgsConstructor;
import org.hibernate.service.spi.ServiceException;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Objects;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class ModelServiceImpl implements ModelService{

    private final ModelRepository modelRepository;

    public List<ModelDTO> getAllModels() {
        List<Model> models = modelRepository.findAll();
        List<ModelDTO> dtos = models.stream().map(this::getModelDTO).toList();
        return dtos;
    }

    public ModelDTO getModelByID(Long id) {
        Optional<Model> optModel = modelRepository.findById(id);
        return optModel.isEmpty() ? null : getModelDTO(optModel.get());
    }

    public ModelDTO getModelDTO(Model model) {
        ModelDTO dto = new ModelDTO();
        dto.setId((long) Math.toIntExact(model.getId()));
        dto.setName(model.getName());
        // BrandDTO artık kullanılmayacak
        return dto;
    }

    public Model saveModel(ModelSaveDTO dto) throws Exception {
        if (Objects.isNull(dto.getBrandId()))
            throw new Exception("Brand alanı boş olamaz");
        // Brand bağımlılığını kaldırdığınız için brandId'yi kullanarak doğrudan Model nesnesini oluşturmalısınız
        Model model = new Model();
        model.setName(dto.getName());
        // Brand bağımlılığını kaldırdığınız için brandId'yi kullanarak doğrudan Model nesnesine set etmelisiniz
        // model.setBrandId(dto.getBrandId()); // Örnek bir kullanım, gerçek uygulamaya uygun şekilde düzenleyin
        return modelRepository.save(model);
    }

    public Model updateModel(ModelUpdateDTO dto) throws Exception {
        Optional<Model> optModel = modelRepository.findById(Long.valueOf(dto.getId()));
        if (optModel.isEmpty())
            throw new Exception("ID yanlış");
        Model model = optModel.get();
        if (Objects.nonNull(dto.getName())) {
            model.setName(dto.getName());
        }
        // Brand bağımlılığını kaldırdığınız için brandId'yi doğrudan kullanamazsınız, güncelleme işlemi için başka bir yaklaşım belirlemeniz gerekebilir
        // model.setBrandId(dto.getBrandId()); // Örnek bir kullanım, gerçek uygulamaya uygun şekilde düzenleyin
        return modelRepository.save(model);
    }

    public void deleteModel(Long id) {
        modelRepository.deleteById(id);
    }

    @Override
    public ModelDTO addModel(ModelDTO dto) {
        try {
            Model model = mapModelDtoToEntity(dto);
                model = modelRepository.save(model);
                return mapEntityToModelDto(model);
            } catch (Exception ex) {
                throw new ServiceException("Model Kayıt Sırasında Hata Oluştu", ex);
            }
    }



    private Model mapModelDtoToEntity(ModelDTO dto) {
        Model entity = new Model();
        entity.setId(dto.getId());
        entity.setName(dto.getName());

        return entity;
    }

    private ModelDTO mapEntityToModelDto(Model entity){
        ModelDTO dto = new ModelDTO();
        dto.setId(entity.getId());
        dto.setName(entity.getName());
        return dto;
    }

}
