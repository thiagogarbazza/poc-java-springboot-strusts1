package com.github.thiagogarbazza.pocs.app.utils.buildinfo;

import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.env.Environment;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
@PropertySource(ignoreResourceNotFound = true, value = "classpath:app-version-info.properties")
public class BuildInfoService {

    private final Environment environment;

    public BuildInfoDTO buscar() {
        return BuildInfoDTO.builder()
            .version(environment.getProperty("app.version-info.version", "0.0.0-local"))
            .dateTime(environment.getProperty("app.version-info.date-time", "0000-00-00 00:00:00"))
            .gitCommitHash(environment.getProperty("app.version-info.git-commit-hash", "git-commit hash"))
            .gitCommitBranch(environment.getProperty("app.version-info.git-commit-branch", "git-commit branch-name"))
            .build();
    }
}
