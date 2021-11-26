/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package arbol;

/**
 *
 * @author Reinel
 */
public class ArbolBin {
    
    NodoArbol raiz;

    public ArbolBin() {

        raiz = null;
    }

    public void Insertarnombre(Carro d) {

        NodoArbol nuevo = new NodoArbol(d);

        if (raiz == null) {
            raiz = nuevo;

        } else {
            NodoArbol auxiliar = raiz;
            NodoArbol padre;

            while (true) {
                padre = auxiliar;
                if (d.ascii() < auxiliar.dato.ascii()) {
                    auxiliar = auxiliar.izq;
                    
            if (auxiliar == null) {
                        padre.izq = nuevo;
                        return;
                    }
                } else {
                    auxiliar = auxiliar.der;
                    if (auxiliar == null) {
                        padre.der = nuevo;
                        return;
                    }
                }
            }
        }
    }
    
    public boolean Vacio() {

        return raiz == null;
    }

    public void InOrden(NodoArbol r) {

        if (r != null) {
            InOrden(r.izq);
            System.out.println("Placa\n"+r.dato.Placa()+"Hora\n"+r.dato.Hora()+"Conductor\n"+r.dato.Conductor());
            InOrden(r.der);
        }
    }

    public void PreOrden(NodoArbol r) {

        if (r != null) {

            System.out.println("Placa\n"+r.dato.Placa()+"Hora\n"+r.dato.Hora()+"Conductor\n"+r.dato.Conductor());
            PreOrden(r.izq);
            PreOrden(r.der);
        }
    }

    public void PostOrden(NodoArbol r) {

        if (r != null) {

            PostOrden(r.izq);
            PostOrden(r.der);
            System.out.println("Placa"+r.dato.Placa()+"Hora"+r.dato.Hora()+"Conductor"+r.dato.Conductor());

        }
    }

    public NodoArbol BuscarNodo(Carro d) {
        NodoArbol aux = raiz;
        while (aux.dato != d) {
            if (d.ascii() < aux.dato.ascii()) {
                aux = aux.izq;
            } else {
                aux = aux.der;
            }
            if (aux == null) {
                return null;
            }
        }
        return aux;
    }

    public boolean Eliminar(Carro d) {

        NodoArbol auxiliar = raiz;
        NodoArbol padre = raiz;
        boolean hijoizq = true;
        while (auxiliar.dato.ascii() != d.ascii()) {
            padre = auxiliar;
            if (d.ascii() < auxiliar.dato.ascii()) {
                hijoizq = true;
                auxiliar = auxiliar.izq;
            } else {
                hijoizq = false;
                auxiliar = auxiliar.der;
            }
            if (auxiliar == null) {

                return false;
            }
        }
        if (auxiliar.izq == null && auxiliar.der == null) {
            if (auxiliar == raiz) {
                raiz = null;
            } else if (hijoizq) {
                padre.izq = null;
            } else {
                padre.der = null;
            }
        } else if (auxiliar.der == null) {
            if (auxiliar == raiz) {
                raiz = auxiliar.izq;
            } else if (hijoizq) {
                padre.izq = auxiliar.izq;
            } else {
                padre.der = auxiliar.izq;
            }
        } else if (auxiliar.izq == null) {
            if (auxiliar == raiz) {
                raiz = auxiliar.der;
            } else if (hijoizq) {
                padre.izq = auxiliar.der;
            } else {
                padre.der = auxiliar.der;
            }
        } else {
            NodoArbol reemplazo = ObtenerRemplazo(auxiliar);
            if (auxiliar == raiz) {
                raiz = reemplazo;
            } else if (hijoizq) {
                padre.izq = reemplazo;
            } else {
                padre.der = reemplazo;
            }
            reemplazo.izq = auxiliar.izq;
        }

        return true;

    }

    public NodoArbol ObtenerRemplazo(NodoArbol nodoreemplazo) {
        NodoArbol reemplazarpadre = nodoreemplazo;
        NodoArbol reemplazo = nodoreemplazo;
        NodoArbol auxiliar = nodoreemplazo.der;
        while (auxiliar != null) {
            reemplazarpadre = reemplazo;
            reemplazo = auxiliar;
            auxiliar = auxiliar.izq;
        }
        if (reemplazo != nodoreemplazo.der) {
            reemplazarpadre.izq = nodoreemplazo.der;
            reemplazo.der = nodoreemplazo.der;
        }
        System.out.println("El nodo a remplazar es:"+ reemplazo.dato.Placa());
        return reemplazo;
    }

    public void hermanos(NodoArbol raiz) {
        NodoArbol Aux = raiz;

        if (raiz != null) {
            while (Aux.izq != null && Aux.der != null) {
                System.out.println("hermano"+ Aux.der.dato.Placa()+"-"+Aux.izq.dato.Placa());
                Aux = Aux.izq;
                if (Aux == null) {

                }
            }
        }
    }

    public void borrarMenor() {
        if (raiz != null) {
            if (raiz.izq == null) {
                raiz = raiz.der;
            } else {
                NodoArbol ant = raiz;
                NodoArbol recorido = raiz.izq;
                while (recorido.izq != null) {
                    ant = recorido;
                    recorido = recorido.izq;
                }
                ant.izq = null;
            }
        }
    }

    public void borrarMayor() {
        if (raiz != null) {
            if (raiz.der == null) {
                raiz = raiz.izq;
            } else {
                NodoArbol ant = raiz;
                NodoArbol recorido = raiz.der;
                while (recorido.izq != null) {
                    ant = recorido;
                    recorido = recorido.der;
                }
                ant.der = null;
            }
        }
    }

    public NodoArbol Raiz() {
        return raiz;
    }
   
}



