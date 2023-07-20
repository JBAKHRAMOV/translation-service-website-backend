package com.company.auth.service;

import com.company.auth.dto.*;
import com.company.component.ResDTO;

public interface AuthenticationService {
    ResDTO register(RegisterRequest request);
    ResDTO authenticate(AuthenticationRequest request);
}
