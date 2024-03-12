package com.example.minitest2.controller;

import com.example.minitest2.model.dto.TotalAmount;
import com.example.minitest2.model.entity.Category;
import com.example.minitest2.service.category.CategoryService;
import com.example.minitest2.service.category.ICategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.Optional;

@Controller
@RequestMapping("category")
public class CategoryController {
    @Autowired
    private ICategoryService categoryService;
    @GetMapping
    public ModelAndView showList(@PageableDefault(size = 3) Pageable pageable){
        ModelAndView modelAndView = new ModelAndView("categoryview/list");
        modelAndView.addObject("category", categoryService.findAll(pageable));
        return modelAndView;
    }
    @GetMapping("/create")
    public ModelAndView createForm(){
        ModelAndView modelAndView = new ModelAndView("categoryview/create");
        modelAndView.addObject("category", new Category());
        return modelAndView;
    }
    @PostMapping("/create")
    public String saveCategory(@ModelAttribute("category") Category category, RedirectAttributes redirectAttributes){
        categoryService.save(category);
        redirectAttributes.addFlashAttribute("message", "Successfully create new category");
        return "redirect:/category";
    }
    @GetMapping("/update/{id}")
    public ModelAndView updateForm(@PathVariable Long id){
        Category category = categoryService.findById(id);
        if (category!=null){
            ModelAndView modelAndView = new ModelAndView("categoryview/update");
            modelAndView.addObject("category",category);
            return modelAndView;
        } else {
            return new ModelAndView("/error");
        }
    }
    @PostMapping("/update/{id}")
    public String update(@ModelAttribute("category") Category category, RedirectAttributes attributes){
        categoryService.save(category);
        attributes.addFlashAttribute("message", "Update successfully");
        return "redirect:/category";
    }
    @GetMapping("/delete/{id}")
    public String delete(@PathVariable Long id, RedirectAttributes attributes){
        categoryService.remove(id);
        attributes.addFlashAttribute("message", "Delete successfully");
        return "redirect:/category";
    }
//    @GetMapping("/total")
//    public ModelAndView total(){
//        ModelAndView modelAndView = new ModelAndView("/categoryview/total");
//        Iterable<TotalAmount> totalAmounts = categoryService.getTotalAmount();
//        modelAndView.addObject("totals", totalAmounts);
//        return modelAndView;
//    }
}
