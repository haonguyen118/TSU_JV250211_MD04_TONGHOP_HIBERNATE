package com.example.com.controller;

import com.example.com.model.Category;
import com.example.com.model.Seed;
import com.example.com.service.CategoryService;
import com.example.com.service.SeedService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.ArrayList;
import java.util.List;

@Controller
@RequestMapping("/seeds")
public class SeedController {
    @Autowired
    private SeedService seedService;
    @Autowired
    private CategoryService categoryService;

    @GetMapping
    public String seeds(Model model, @RequestParam (name = "page", defaultValue = "1") int page, @RequestParam (name = "size", defaultValue = "8") int size, @RequestParam( name = "search", required = false) String search) {
        List<Seed> seeds = seedService.findAllAndSearch(page, size, search);
        long total = seedService.countAllSeed(search);
        int totalPage = (int) Math.ceil(total/(double)size);
        List<Integer> pageList = new ArrayList<>();
        for(int i=0;i<totalPage;i++){
            pageList.add(i+1);
        }
        model.addAttribute("search", search);
        model.addAttribute("pageList", pageList);
        model.addAttribute("page",page);
        model.addAttribute("size",size);
        model.addAttribute("seeds", seeds);
        return "seeds";
    }

    @GetMapping("/add")
    public String showAddSeeds(Model model ) {
        model.addAttribute("categories", categoryService.findAll());
        Seed seed = new Seed();
        model.addAttribute("seed", seed);
        return "addSeed";
    }

    @PostMapping("/add")
    public String addSeeds(@ModelAttribute Seed seed, Model model, RedirectAttributes redirectAttributes) {
        if (seedService.checkExistSeedName(seed.getSeedName())) {
            model.addAttribute("seed", seed);
            model.addAttribute("message", "Tên hạt giống đã tồn tại");
            return "addSeed";
        } else {
            boolean result = seedService.addSeed(seed);
            if (result) {
                redirectAttributes.addFlashAttribute("message", "Thêm hạt giống thành công");
                return "redirect:/seeds";
            } else {
                model.addAttribute("message", "thêm hạt giống thất bại");
                model.addAttribute("seed", seed);
                return "addSeed";
            }
        }
    }

    @GetMapping("/edit/{id}")
    public String showEditSeeds(@PathVariable("id") Long seedId, Model model) {
        Seed seed = seedService.findSeedById(seedId);
        model.addAttribute("categories", categoryService.findAll());
        model.addAttribute("seed", seed);
        return "updateSeed";
    }

    @PostMapping("/edit/{id}")
    public String updateSeeds(@ModelAttribute("seed") Seed seed, Model model, RedirectAttributes redirectAttributes, @PathVariable String id) {
        Seed updatedSeed = seedService.findSeedById(seed.getSeedId());
        if (seedService.checkExistSeedName(seed.getSeedName()) && updatedSeed.getSeedName().equals(seed.getSeedName())) {
            model.addAttribute("error", "Tên hạt giống đã tồn tại");
            model.addAttribute("seed", seed);
            return "updateSeed";
        } else {
            boolean result = seedService.updateSeed(seed);
            if (result) {
                redirectAttributes.addFlashAttribute("message", "Cập nhật hạt giống thành công");
                return "redirect:/seeds";
            } else {
                model.addAttribute("message", "Cập nhật thất bại");
                model.addAttribute("seed", seed);
                model.addAttribute("id", seed.getSeedId());
                return "updateSeed";
            }


        }
    }

    @GetMapping("/delete/{id}")
    public String deleteSeeds(@PathVariable("id") Long id, Model model, RedirectAttributes redirectAttributes) {
        boolean result = seedService.deleteSeed(id);
        if (result) {
            redirectAttributes.addFlashAttribute("message", "Xóa thành công");
        } else {
            redirectAttributes.addFlashAttribute("message", "Xóa thất bại");
        }
        return "redirect:/seeds";

    }
}
