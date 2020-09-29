package com.example.avaliacao;

public class FolhaDePagamento {
    private String nome;
    private int HorasTrabalhadas;
    private float valorDaHora;
    private int mes;
    private int ano;
    private float salarioBruto;
    private float salarioLiquido;
    private float valorIR;
    private float valorINSS;
    private float valorFGTS;

    public FolhaDePagamento(String nome, int numeroDeHorasTrabalhadas, float valorDaHora, int mes, int ano) {
        this.nome = nome;
        this.HorasTrabalhadas = numeroDeHorasTrabalhadas;
        this.valorDaHora = valorDaHora;
        this.mes = mes;
        this.ano = ano;
        calcularSalarioBruto();
        calcularIR();
        calcularINSS();
        calcularFGTS();
        calcularSalarioLiquido();
    }

    public float getSalBruto() {
        return salarioBruto;
    }

    public void setSalBruto(float salBruto) {
        this.salarioBruto = salBruto;
    }

    public float getSalLiq() {
        return salarioLiquido;
    }

    public void setSalLiq(float salLiq) {
        this.salarioLiquido = salLiq;
    }

    public float getIr() {
        return valorIR;
    }

    public void setIr(float ir) {
        this.valorIR = ir;
    }

    public float getInss() {
        return valorINSS;
    }

    public void setInss(float inss) {
        this.valorINSS = inss;
    }

    public float getFgts() {
        return valorFGTS;
    }

    public void setFgts(float fgts) {
        this.valorFGTS = fgts;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public int getNumeroDeHorasTrabalhadas() {
        return HorasTrabalhadas;
    }

    public void setNumeroDeHorasTrabalhadas(int numeroDeHorasTrabalhadas) {
        this.HorasTrabalhadas = numeroDeHorasTrabalhadas;
    }

    public float getValorDaHora() {
        return valorDaHora;
    }

    public void setValorDaHora(float valorDaHora) {
        this.valorDaHora = valorDaHora;
    }

    public int getMes() {
        return mes;
    }

    public void setMes(int mes) {
        this.mes = mes;
    }

    public int getAno() {
        return ano;
    }

    public void setAno(int ano) {
        this.ano = ano;
    }

    public void calcularSalarioBruto(){
        this.salarioBruto = this.valorDaHora * this.HorasTrabalhadas;
    }

    public void calcularIR(){
        if(this.salarioBruto <= 1372.81f){
            this.valorIR = 0;
        }else if(this.salarioBruto <= 2743.25f){
            this.valorIR = this.salarioBruto * 0.15f;
        }else{
            this.valorIR = this.salarioBruto * 0.275f;
        }
    }

    public void calcularINSS(){
        if(this.salarioBruto <= 868.29f){
            this.valorINSS = this.salarioBruto * 0.08f;
        }else if(this.salarioBruto <= 1447.14f){
            this.valorINSS = this.salarioBruto * 0.09f;
        }else if(this.salarioBruto <= 2894.28f){
            this.valorINSS = this.salarioBruto * 0.11f;
        }else{
            this.valorINSS = 318.37f;
        }
    }

    public void calcularFGTS(){
        this.valorFGTS = this.salarioBruto * 0.08f;
    }

    public void calcularSalarioLiquido(){
        this.salarioLiquido = this.salarioBruto - this.valorIR - this.valorINSS;
    }



    @Override
    public String toString() {
        return this.nome;
    }
}

