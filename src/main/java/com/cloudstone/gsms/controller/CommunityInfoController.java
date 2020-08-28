package com.cloudstone.gsms.controller;

import com.cloudstone.gsms.domain.CommunityInfo;
import com.cloudstone.gsms.dto.Result;
import com.cloudstone.gsms.repository.CommunityInfoRepository;
import com.cloudstone.gsms.service.CommunityInfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
@RequestMapping(value = "/communityinfo")
public class CommunityInfoController {

    @Autowired
    private CommunityInfoRepository communityInfoRepository;
    @Autowired
    private CommunityInfoService communityInfoService;
    @PostMapping("/addCommunityInfo")
    public Result<CommunityInfo> addCommunityInfo(@Valid CommunityInfo communityInfo, BindingResult bindingResult) throws Exception{
        return communityInfoService.addCommunity(communityInfo,bindingResult);
    }

    @GetMapping("/findCommunityInfo/{id}")
    public Result<CommunityInfo> findCommunityInfo(@PathVariable Integer id){
        return communityInfoService.findCommunityInfoById(id);
    }
}
