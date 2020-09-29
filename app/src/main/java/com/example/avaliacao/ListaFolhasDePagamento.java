package com.example.avaliacao;


import java.util.ArrayList;

public class ListaFolhasDePagamento {

   private static ArrayList<FolhaDePagamento> ListaFolhaDePagamento = new ArrayList<>();

   public static void addFolha(FolhaDePagamento folhaDePagamento){
       ListaFolhaDePagamento.add(folhaDePagamento);
   }

   public static FolhaDePagamento getFolha(int index){

       return ListaFolhaDePagamento.get(index);
   }

   public static ArrayList<FolhaDePagamento> getLista(){

       return ListaFolhaDePagamento;
   }

}
