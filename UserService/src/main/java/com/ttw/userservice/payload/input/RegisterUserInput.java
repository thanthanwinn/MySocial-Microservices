    package com.ttw.userservice.payload.input;

    import com.ttw.userservice.model.User;
    import jakarta.validation.constraints.Email;
    import jakarta.validation.constraints.Min;
    import jakarta.validation.constraints.NotBlank;
    import jakarta.validation.constraints.NotNull;

    public record RegisterUserInput(
            @NotBlank(message = "Username is required")
            String username,
            @NotBlank(message = "Email is required")
            @Email(message = "Email format is invalid")
            String email,
            @NotNull(message = "Age is required")
            @Min(value = 13, message = "Minimum age is 13")
            Integer age
    ) {
        public User model(RegisterUserInput input) {
            var user = new User();
            user.setUsername(input.username);
            user.setEmail(input.email);
            user.setAge(input.age);
            return user;
        }
    }
