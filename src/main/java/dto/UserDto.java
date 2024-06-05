package dto;

import lombok.*;

@Setter
@Getter
@NoArgsConstructor
@ToString
@AllArgsConstructor
public class UserDto {
    private String userName;
    private String email;
    private String phoneNumber;
    private String nic;
    private String password;
    private String passwordAgain;
}
