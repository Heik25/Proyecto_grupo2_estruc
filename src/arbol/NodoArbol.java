
package arbol;


public class NodoArbol {
    Carro dato;
    NodoArbol izq,der;
    
    public NodoArbol(Carro d){
     dato = d;
     izq=der=null;
    }
    
    public String toString(){
    return "el dato es:"+dato;
    }
}
