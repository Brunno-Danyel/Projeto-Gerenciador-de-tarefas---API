package application.domain.entities;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import javax.validation.constraints.Email;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Entity
public class Usuario implements Serializable {
    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Email
    @Column(name = "tb_login_usuario")
    private String login;

    @Column(name = "tb_nome_usuario")
    private String nome;

    @JsonIgnore
    @Column(name = "tb_senha_user")
    private String senha;

    @JsonIgnore
    @OneToMany(mappedBy = "responsavel")
    private List<Tarefa> tarefa = new ArrayList<>();

    @JsonIgnore
    private boolean admin;

    public Usuario(String login, String nome, String senha) {
        this.login = login;
        this.nome = nome;
        this.senha = senha;
    }

}
