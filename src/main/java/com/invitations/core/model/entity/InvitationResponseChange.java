package com.invitations.core.model.entity;

import com.invitations.core.model.constant.ChangeType;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.PrePersist;
import javax.persistence.Table;
import java.util.Date;
import java.util.List;

@Entity
@Table(
    name = "invitation_response_change"
)
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class InvitationResponseChange extends EntityWithLongId {

  @ManyToOne
  @JoinColumn(name = "invitation_response", referencedColumnName = "id")
  private InvitationResponse invitationResponse;

  @Column(name = "change_type")
  @Enumerated(value = EnumType.STRING)
  private ChangeType changeType;

  @Column(name = "created_date")
  private Date date;

  @OneToMany(fetch = FetchType.LAZY, mappedBy = "invitationResponseChange")
  private List<InvitationResponseChangeItem> invitationResponseChangeItems;

  @PrePersist
  public void generateDate() {
    date = new Date();
  }
}
