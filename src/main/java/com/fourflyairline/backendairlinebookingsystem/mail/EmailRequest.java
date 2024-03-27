package com.fourflyairline.backendairlinebookingsystem.mail;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class EmailRequest {
   private String to;
   private String subject;
   private String body;
}
