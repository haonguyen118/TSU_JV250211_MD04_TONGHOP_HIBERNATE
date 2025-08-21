package com.example.com.controller;

import com.example.com.model.Category;
import com.example.com.service.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.List;

@Controller
@RequestMapping("/categories")
public class CategoryController {
    @Autowired
    private CategoryService categoryService;

    @GetMapping
    public String getCategories(Model model) {
        List<Category> categories = categoryService.findAll();
        model.addAttribute("categories", categories);
        return "categories";
    }
    @GetMapping("/add")
    public String showAddCategory(Model model) {
        Category category = new Category();
        model.addAttribute("category",category);
        return "addCategory";
    }
    @PostMapping("/add")
    public String addCategory(@ModelAttribute("category") Category category, Model model, RedirectAttributes redirectAttributes) {
       if (categoryService.checkExistCategoryName(category.getCatalogName())){
          model.addAttribute("category", category);
          model.addAttribute("message", "Tên danh mục đã tồn tại");
          return "addCategory";
        }else {
           boolean rs = categoryService.save(category);
           if (rs) {
               redirectAttributes.addFlashAttribute("message","Thêm danh mục thành công");
               return "redirect:/categories";
           }else {
               model.addAttribute("message","Thêm danh mục thất bại");
               model.addAttribute("category", category);
               return  "addCategory";
           }
       }
    }
    @GetMapping("/edit/{id}")
    public String showEditCategory(@PathVariable("id") Long id, Model model) {
       model.addAttribute("category", categoryService.findById(id));
       model.addAttribute("categories", categoryService.findAll());
        return "updateCategory";
    }
    @PostMapping("/edit/{id}")
    public String updateCategory(@ModelAttribute("category") Category category, Model model, RedirectAttributes redirectAttributes) {
        Category oldCategory = categoryService.findById(category.getId());
        if (categoryService.checkExistCategoryName(category.getCatalogName()) && oldCategory.getCatalogName().equals(category.getCatalogName())) {
            model.addAttribute("error","Tên danh mục đã tồn tại");
            model.addAttribute("category", category);
            model.addAttribute("id",category.getId());
            model.addAttribute("categories", categoryService.findAll());
            return "updateCategory";
        }else {
            boolean rs = categoryService.update(category);
            if (rs) {
                redirectAttributes.addFlashAttribute("message","cập nhật thành công");
                return "redirect:/categories";
            }else {
                model.addAttribute("message","Cập nhật thất bại");
                model.addAttribute("category", category);
                model.addAttribute("id",category.getId());
                model.addAttribute("categories", categoryService.findAll());
                return "updateCategory";
            }
        }
    }
    @GetMapping("/delete/{id}")
    public String deleteCategory(@PathVariable("id") Long id, RedirectAttributes redirectAttributes) {
       boolean rs = categoryService.deleteById(id);
       if (rs) {
           redirectAttributes.addFlashAttribute("message","Xóa thành công");
       }else {
           redirectAttributes.addFlashAttribute("message", "Xóa thất bại");
       }
        return  "redirect:/categories";
    }
}
