package com.azurealstn.blogproject.domain.board;

import com.azurealstn.blogproject.domain.BaseTimeEntity;
import com.azurealstn.blogproject.domain.reply.Reply;
import com.azurealstn.blogproject.domain.user.User;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.List;

@Builder
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Entity
public class Board extends BaseTimeEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false, length = 100)
    private String title;

    @Lob /* 대용량 데이터를 저장할 때 사용 DB 데이터 타입은 = LongText */
    private String content;

    @Column
    private int count;

    @ManyToOne(fetch = FetchType.EAGER) /* 즉시 로딩으로 설정하여 관련된 유저 정보도 같이 가져옴 */
    @JoinColumn(name = "userId")
    private User user;

    @OrderBy("id desc")
    @JsonIgnoreProperties({"board"})
    @OneToMany(mappedBy = "board", fetch = FetchType.EAGER, cascade = CascadeType.REMOVE) /* Board Entity 하위의 Reply List 조회 */
    private List<Reply> replyList;

    public void update(String title, String content) {
        this.title = title;
        this.content = content;
    }
}
