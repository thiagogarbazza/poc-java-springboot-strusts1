package com.github.thiagogarbazza.pocs.app.web.api;

import com.github.thiagogarbazza.pocs.app.utils.buildinfo.BuildInfoDTO;
import com.github.thiagogarbazza.pocs.app.utils.buildinfo.BuildInfoService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/build-info")
class BuildInfoRestController {

    private final BuildInfoService buildInfoService;

    @GetMapping
    public BuildInfoDTO BuildInfo() {
        return buildInfoService.buscar();
    }
}
