package com.cloudstone.gsms.controller;

import com.cloudstone.gsms.repository.TrashManagerRepository;
import com.cloudstone.gsms.service.TrashManagerService;
import com.cloudstone.gsms.mapper.TrashManager;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Example;
import org.springframework.web.bind.annotation.*;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping(value = "/trashmanager")
public class TrashManagerController {
    @Autowired
    private TrashManagerRepository trashManagerRepository;
    @Autowired
    private TrashManagerService trashManagerService;

    @GetMapping("/findTrashManagerById/{id}")
    public TrashManager findTrashManagerById(@PathVariable Integer id){
        return trashManagerRepository.findById(id).orElse(null);
    }

    @GetMapping("/findTrashManagerAll")
    public List<TrashManager> findTrashManagerAll(){
        return trashManagerRepository.findAll();
    }
    @PostMapping("findTrashManagerByIdAndName/{id}")
    public List<TrashManager> findTrashManagerByIdAndName(@PathVariable Integer id, @RequestParam String name ){
        TrashManager trashManager = new TrashManager();
        //trashManager.setId(Id);
        trashManager.setName(name);
        trashManager.setAge(1);
        Example<TrashManager> example = Example.of(trashManager);
        return trashManagerRepository.findAll(example);
    }

    @PostMapping("/saveTrashManager/{id}")
    public TrashManager saveTrashManager(@PathVariable Integer id,@RequestParam String address){
        Optional<TrashManager> optional = trashManagerRepository.findById(id);

        TrashManager trashManager = null;
        if (optional.isPresent() == true){
            trashManager = optional.get();
            trashManager.setAddress(address);
            trashManagerRepository.save(trashManager);
        }
        return trashManager;
    }

    @GetMapping("/addTrashManagerList")
    public List<TrashManager> addTrashManagerList(){
        List<TrashManager> list = trashManagerService.addTrashManagerList();
        return list;
    }
}
