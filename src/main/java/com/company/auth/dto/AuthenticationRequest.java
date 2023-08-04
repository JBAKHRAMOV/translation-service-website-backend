package com.company.auth.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class AuthenticationRequest {
  @NotBlank @NotNull @Pattern(regexp = "^\\+(?:[0-9] ?){6,14}[0-9]$")
  private String phoneNum;
  @NotBlank @NotNull
  private String password;
}
