package br.com.delivery.deliveryapi.model;

import br.com.delivery.deliveryapi.enums.Role;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.UUID;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity(name = "users")
public class User {

  @Id
  @GeneratedValue(generator = "UUID")
  private UUID id;

  private String name;

  @Column(unique = true)
  private String login;

  private String password;

  @Enumerated(EnumType.STRING)
  private Role role;
}
