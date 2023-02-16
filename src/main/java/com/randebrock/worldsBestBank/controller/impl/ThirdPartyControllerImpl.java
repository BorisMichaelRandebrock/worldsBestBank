package com.randebrock.worldsBestBank.controller.impl;

import com.randebrock.worldsBestBank.repository.ThirdPartyRepository;
import com.randebrock.worldsBestBank.service.interfaces.ThirdPartyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ThirdPartyControllerImpl {
    @Autowired
    private ThirdPartyService thirdPartyService;

    @Autowired
    private ThirdPartyRepository thirdPartyRepository;
}
