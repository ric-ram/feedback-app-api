package com.ricram.feedbackapp.dtos;

import com.fasterxml.jackson.annotation.JsonView;
import com.ricram.feedbackapp.entity.User;
import com.ricram.feedbackapp.views.Views;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import com.fasterxml.jackson.annotation.JsonProperty;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class AuthenticationResponse {

    @JsonView(Views.Public.class)
    @JsonProperty("access_token")
    private String accessToken;

    @JsonView(Views.Public.class)
    @JsonProperty("refresh_token")
    private String refreshToken;

}
