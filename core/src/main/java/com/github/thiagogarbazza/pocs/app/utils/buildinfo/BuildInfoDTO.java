package com.github.thiagogarbazza.pocs.app.utils.buildinfo;

import lombok.Builder;
import lombok.Getter;

@Getter
@Builder
public class BuildInfoDTO {

    private final String version;
    private final String dateTime;
    private final String gitCommitHash;
    private final String gitCommitBranch;
}
