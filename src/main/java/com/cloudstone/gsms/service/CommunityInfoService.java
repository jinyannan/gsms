package com.cloudstone.gsms.service;

import com.cloudstone.gsms.domain.CommunityInfo;
import com.cloudstone.gsms.dto.Result;
import com.cloudstone.gsms.exception.GsmsException;
import com.cloudstone.gsms.repository.CommunityInfoRepository;
import com.cloudstone.gsms.utils.ResultUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.validation.BindingResult;

import java.util.Optional;

@Service
public class CommunityInfoService {

    @Autowired
    private CommunityInfoRepository communityInfoRepository;

    public Result<CommunityInfo> addCommunity(CommunityInfo communityInfo, BindingResult bindingResult){
        if (bindingResult.hasErrors()){
            throw new GsmsException(101, bindingResult.getFieldError().getDefaultMessage());
        }
        return ResultUtil.success(communityInfoRepository.save(communityInfo));
    }

    public Result<CommunityInfo> findCommunityInfoById(Integer id){
        Optional<CommunityInfo> optional = communityInfoRepository.findById(id);

        if (optional.isPresent()){
            return ResultUtil.success(optional.get());
        } else {
            return ResultUtil.fail("数据不存在");
        }
    }
}