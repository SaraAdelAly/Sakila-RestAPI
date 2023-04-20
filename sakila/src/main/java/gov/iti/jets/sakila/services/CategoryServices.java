package gov.iti.jets.sakila.services;

import gov.iti.jets.sakila.dto.CategoryDto;
import gov.iti.jets.sakila.persistence.dao.CategoryDao;
import gov.iti.jets.sakila.persistence.entities.Category;

import org.modelmapper.ModelMapper;

public class CategoryServices {
    private ModelMapper modelMapper = new ModelMapper();
    private CategoryDao categoryDao = new CategoryDao();
    public CategoryServices(ModelMapper modelMapper, CategoryDao categoryDao){
        this.modelMapper = modelMapper;
        this.categoryDao= categoryDao;
    }

    public CategoryDto getFilmCategory (String title){
        Category category = categoryDao.getFilmCategory(title);
        return modelMapper.map(category, CategoryDto.class);
    }

    public CategoryDto addCategory (CategoryDto categoryDto){
        Category category = modelMapper.map(categoryDto, Category.class);
        return  modelMapper.map(categoryDao.addCategory(category), CategoryDto.class);
    }
}
