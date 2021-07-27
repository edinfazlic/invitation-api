package com.invitations.core.model.entity;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(
    name = "invitation_access"
)
@Getter
@Setter
@NoArgsConstructor
public class InvitationAccess extends EntityWithLongId {

  @ManyToOne
  @JoinColumn(name = "invitation_user", referencedColumnName = "id")
  private UserEntity user;

  @ManyToOne
  @JoinColumn(name = "invitation", referencedColumnName = "id")
  private Invitation invitation;

}
