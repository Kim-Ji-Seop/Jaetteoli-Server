package com.uou.capstone.domain.app.user.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class PostAuthEmailAfterReq {
    private String email;
    private String authEmailCheck;
}
