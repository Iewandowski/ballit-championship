package com.lewandowski.backend_ballit_championship.dto.request;

import java.sql.Date;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Builder;
import lombok.Data;

@Builder
@Data
public class TeamRequest {
    @NotBlank(message = "Nome precisa ser informado")
    private String name;

    @NotBlank(message = "Grito de Guerra precisa ser informado")
    private String battle_cry;

    @NotNull(message = "Data de fundação precisa ser informada")
    private Date foundation_year;
}
