package com.ricram.feedbackapp.dtos;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonView;
import com.ricram.feedbackapp.entity.User;
import com.ricram.feedbackapp.entity.UserRole;
import com.ricram.feedbackapp.views.Views;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class UserResponse {

    @JsonView(Views.Public.class)
    private User user;
}
