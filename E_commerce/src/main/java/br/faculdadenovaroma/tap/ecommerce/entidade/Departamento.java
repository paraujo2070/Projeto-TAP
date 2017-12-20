package br.faculdadenovaroma.tap.ecommerce.entidade;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "TB_DEPARTAMENTO")
public class Departamento {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "TB_DEP_COD", nullable = false)
    private int codigo;
    @Column(name = "TB_DEP_NOME", nullable = false)
    private String nome;

    @OneToMany(fetch = FetchType.LAZY, mappedBy = "departamento")
    private List<Produto> produtos;

    public Departamento() {
    }

    public Departamento(String nome) {
        this.nome = nome;
    }

    public void setCodigo(int codigo) {
        this.codigo = codigo;
    }

    public int getCodigo() {
        return this.codigo;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getNome() {
        return this.nome;
    }
}
