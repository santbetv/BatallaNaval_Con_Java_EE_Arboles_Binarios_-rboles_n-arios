package com.BatallaNavalArboles.controladores;

import com.BatallaNavalArboles.execepciones.BatallaNabalExcepcion;
import com.BatallaNavalArboles.modelo.ArbolBinarioB;
import com.BatallaNavalArboles.modelo.ArbolN;
import com.BatallaNavalArboles.modelo.BarcoPosicionado;
import com.BatallaNavalArboles.modelo.Coordenada;
import com.BatallaNavalArboles.modelo.NodoABB;
import com.BatallaNavalArboles.modelo.NodoN;
import com.BatallaNavalArboles.modelo.Rol;
import com.BatallaNavalArboles.modelo.TipoBarco;
import com.BatallaNavalArboles.modelo.Usuario;
import com.caracolesdecolores.controlador.util.JsfUtil;
import javax.inject.Named;
import javax.enterprise.context.SessionScoped;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.faces.context.FacesContext;
import org.primefaces.model.diagram.Connection;
import org.primefaces.model.diagram.DefaultDiagramModel;
import org.primefaces.model.diagram.DiagramModel;
import org.primefaces.model.diagram.Element;
import org.primefaces.model.diagram.connector.StraightConnector;
import org.primefaces.model.diagram.endpoint.DotEndPoint;
import org.primefaces.model.diagram.endpoint.EndPoint;
import org.primefaces.model.diagram.endpoint.EndPointAnchor;

/**
 *
 * @author Santiago Betancur Villegas <santiago-betancur at hotmail.com>
 */
@Named(value = "controladorBatalla")
@SessionScoped
public class ControladorBatalla implements Serializable {

    private Usuario administrador;
    private Usuario jugador1;
    private Usuario jugador2;
    private int cantBarcos;
    private ArbolN tablerojug1 = new ArbolN();
    private ArbolN tablerojug2 = new ArbolN();
    private List<Coordenada> disparosjug1;
    private List<Coordenada> disparosjug2;
    private ArbolBinarioB tiposDeBarcos = new ArbolBinarioB();
    //Creador por santiagos

    private TipoBarco tipoBarco = new TipoBarco();
    private String usuarios;
    int codigo = 0;
    String password = "";
    byte columna = 0;
    byte fila = 0;
    byte disparoColumna = 0;
    byte disparoFila = 0;
    int posicionDeBarco = 0;

    //Constructor
    public ControladorBatalla() {
    }

    //Setter and Getter
    public int getPosicionDeBarco() {
        return posicionDeBarco;
    }

    public void setPosicionDeBarco(int posicionDeBarco) {
        this.posicionDeBarco = posicionDeBarco;
    }

    public byte getDisparoColumna() {
        return disparoColumna;
    }

    public void setDisparoColumna(byte disparoColumna) {
        this.disparoColumna = disparoColumna;
    }

    public byte getDisparoFila() {
        return disparoFila;
    }

    public void setDisparoFila(byte disparoFila) {
        this.disparoFila = disparoFila;
    }

    public byte getColumna() {
        return columna;
    }

    public void setColumna(byte columna) {
        this.columna = columna;
    }

    public byte getFila() {
        return fila;
    }

    public void setFila(byte fila) {
        this.fila = fila;
    }

    public Usuario getAdministrador() {
        return administrador;
    }

    public void setAdministrador(Usuario administrador) {
        this.administrador = administrador;
    }

    public Usuario getJugador1() {
        return jugador1;
    }

    public void setJugador1(Usuario jugador1) {
        this.jugador1 = jugador1;
    }

    public Usuario getJugador2() {
        return jugador2;
    }

    public void setJugador2(Usuario jugador2) {
        this.jugador2 = jugador2;
    }

    public int getCantBarcos() {
        return cantBarcos;
    }

    public void setCantBarcos(int cantBarcos) {
        this.cantBarcos = cantBarcos;
    }

    public ArbolN getTablerojug1() {
        return tablerojug1;
    }

    public void setTablerojug1(ArbolN tablerojug1) {
        this.tablerojug1 = tablerojug1;
    }

    public ArbolN getTablerojug2() {
        return tablerojug2;
    }

    public void setTablerojug2(ArbolN tablerojug2) {
        this.tablerojug2 = tablerojug2;
    }

    public List<Coordenada> getDisparosjug1() {
        return disparosjug1;
    }

    public void setDisparosjug1(List<Coordenada> disparosjug1) {
        this.disparosjug1 = disparosjug1;
    }

    public List<Coordenada> getDisparosjug2() {
        return disparosjug2;
    }

    public void setDisparosjug2(List<Coordenada> disparosjug2) {
        this.disparosjug2 = disparosjug2;
    }

    public ArbolBinarioB getTiposDeBarcos() {
        return tiposDeBarcos;
    }

    public void setTiposDeBarcos(ArbolBinarioB tiposDeBarcos) {
        this.tiposDeBarcos = tiposDeBarcos;
    }

    public String getUsuarios() {
        return usuarios;
    }

    public void setUsuarios(String usuarios) {
        this.usuarios = usuarios;
    }

    public TipoBarco getTipoBarco() {
        return tipoBarco;
    }

    public void setTipoBarco(TipoBarco tipoBarco) {
        this.tipoBarco = tipoBarco;
    }

    public int getCodigo() {
        return codigo;
    }

    public void setCodigo(int codigo) {
        this.codigo = codigo;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    ///Metodos
    @PostConstruct
    public void ingresoDeDatos() {
//        tablerojug1.adicionarNodo(new BarcoPosicionado(new TipoBarco("yo", (byte) 0), 0), null);
        administrador = new Usuario("admin@hotmail.com", "Colombia12", new Rol((byte) 4040, "ADMIN"));
        jugador1 = new Usuario("jugador1@hotmail.com", "Colombia12", new Rol((byte) 2020, "JUGADOR1"));
        jugador2 = new Usuario("jugador2@hotmail.com", "Colombia12", new Rol((byte) 1010, "JUGADOR2"));
        try {
            tiposDeBarcos.adicionarNodo(new TipoBarco("Fragata", (byte) 5, (byte) 2));
            tiposDeBarcos.adicionarNodo(new TipoBarco("Rompe", (byte) 6, (byte) 3));
            tiposDeBarcos.adicionarNodo(new TipoBarco("Acorazado", (byte) 4, (byte) 3));
            tiposDeBarcos.adicionarNodo(new TipoBarco("Destructor", (byte) 1, (byte) 2));
            tiposDeBarcos.adicionarNodo(new TipoBarco("Submarino", (byte) 2, (byte) 2));
        } catch (BatallaNabalExcepcion ex) {
            JsfUtil.addErrorMessage(ex.getMessage());
        }
        cargarArbol();
        pintarArbol();
        pintarArbolN();
    }

    //Inicio de adicionar barcosN aparatir del arbolBB
    public void cargarArbol() {
        //Algoritmo
        tablerojug1.adicionarNodo(new BarcoPosicionado(new TipoBarco("yo", (byte) 0), 0), null);
        List<BarcoPosicionado> padres = new ArrayList<>();
        padres.add(tablerojug1.getRaiz().getDato());
        adicionarPreOrden(tiposDeBarcos.getRaiz(), padres, 0, 0);
//            System.out.println("Cantidad: " + contAbb.getArbol().getCantidadNodos());PRUEBASS
    }

    private void adicionarPreOrden(NodoABB reco, List<BarcoPosicionado> padres, int contizq, int contder) {
        if (reco != null) {
            //listaInfantes.add(reco.getDato());
            List<BarcoPosicionado> padresNuevos = new ArrayList<>();
            int contPapas = 0;
            for (byte i = 0; i < reco.getDato().getCantidadJuego(); i++) {
                BarcoPosicionado barcoNuevo = new BarcoPosicionado(new TipoBarco(reco.getDato().getNombre(), reco.getDato().getNroCasillas()), reco.getDato().getCodigo());
//                barcoNuevo.setIdentificador(contizq++);
                barcoNuevo.getTipoBarco().setCodigo(++contizq);

                if (contPapas >= padres.size()) {
                    contPapas = 0;
                }
                tablerojug1.adicionarNodoxCodigo(barcoNuevo, padres.get(contPapas));
                padresNuevos.add(barcoNuevo);
                contPapas++;
            }
            //Validar nuevo codigo          
            contizq = contizq + contder;
            if (reco.getDerecha() != null) {
                contder = reco.getDerecha().getDato().getCantidadJuego();
            }
            adicionarPreOrden(reco.getIzquierda(), padresNuevos, contizq, contder);
            if (reco.getIzquierda() != null) {
                contizq = contizq + reco.getIzquierda().getDato().getCantidadJuego();
            }
            adicionarPreOrden(reco.getDerecha(), padresNuevos, contizq, contder);
        }
    }
    //Final de adicionar barcosN aparatir del arbolBB

    //Inico de conteo de las nombres
    private List<TipoBarco> informacionDeBarcos;

    public List<TipoBarco> getInformacionDeBarcos() {
        return informacionDeBarcos;
    }

    public void setInformacionDeBarcos(List<TipoBarco> informacionDeBarcos) {
        this.informacionDeBarcos = informacionDeBarcos;
    }

    public void barcosEnSistema() {
        informacionDeBarcos = tiposDeBarcos.recorrerPreOrden();
    }
    //Final de conteo de las nombres

    //Inicio de informacion en barcos
    public void datos() {
        informe = tablerojug1.listarHijos();
    }

    String informe = "";

    public String getInforme() {
        return informe;
    }

    public void setInforme(String informe) {
        this.informe = informe;
    }

    public void informeDeBarcos() {
        informeDeTodosLosbarcos = tablerojug1.listarHijosCadena();
    }

    String informeDeTodosLosbarcos = "";

    public String getInformeDeTodosLosbarcos() {
        return informeDeTodosLosbarcos;
    }

    public void setInformeDeTodosLosbarcos(String informeDeTodosLosbarcos) {
        this.informeDeTodosLosbarcos = informeDeTodosLosbarcos;
    }
    //Final de informacion

    //Inicio de coordenadas 
    public void addCoordenadas() {
        tablerojug1.buscarBarcoSeleccionado(Integer.parseInt(barco), columna, fila, posicionDeBarco);
        pintarArbolN();
    }

    public void disparar() {
        disparosXPosicion = disparosXPosicion();
    }

    String disparosXPosicion = "";

    public String getDisparosXPosicion() {
        return disparosXPosicion;
    }

    public void setDisparosXPosicion(String disparosXPosicion) {
        this.disparosXPosicion = disparosXPosicion;
    }
    //Final de coordenas

    //Inicio que me ayuda a colocar posiciones en el tablero
    public String disparosXPosicion() {
        String casillas = "";
        Coordenada[] coordenada = new Coordenada[100];
        Coordenada datos = new Coordenada(columna, fila);
        for (int i = 0; i < coordenada.length; i++) {
            coordenada[i] = datos;
            casillas = "" + coordenada[i].getColumna() + "," + coordenada[i].getFila();
        }
        return casillas;
    }

    String disparosEnOnline = "";

    public String getDisparosEnOnline() {
        return disparosEnOnline;
    }

    public void setDisparosEnOnline(String disparosEnOnline) {
        this.disparosEnOnline = disparosEnOnline;
    }

    public void dipararOnline() {
        disparosEnOnline = "2,2";
    }

    public String disparosEnJuego() {
        String casillas = "";
        Coordenada datosDisparos = new Coordenada(disparoColumna, disparoFila);
        disparosjug1.add(datosDisparos);
        casillas = "" + datosDisparos;
//        for (int i = 0; i < disparosjug1.size(); i++) {
//            casillas += disparosjug1.get(i).getColumna() + "," + disparosjug1.get(i).getFila();
//        }
        return casillas;
    }
    //Final que me ayuda a colocar posiciones en el tablero

    //Inicio de autenticar usuarios
    public String autenticar() {
        if (administrador.getTipoRol().getNombre().toUpperCase().compareTo(usuarios.toUpperCase()) == 0
                && administrador.getTipoRol().getCodigo() == (byte) codigo && administrador.getPassword().equals(password)) {
            return "admin";
        } else if (jugador1.getTipoRol().getNombre().toUpperCase().compareTo(usuarios.toUpperCase()) == 0
                && jugador1.getTipoRol().getCodigo() == (byte) codigo
                && jugador1.getPassword().equals(password)) {
            return "jugador1";
        } else if (jugador2.getTipoRol().getNombre().toUpperCase().compareTo(usuarios.toUpperCase()) == 0
                && jugador2.getTipoRol().getCodigo() == (byte) codigo
                && jugador2.getPassword().equals(password)) {
            return "jugador2";
        }
        JsfUtil.addErrorMessage("Usuario no registrado");
        return null;
    }
    //Final de autenticar usuarios

    //Inicio mostrar tablero
    public int mostrarTablero() {
        int vista = 0;
        if (tiposDeBarcos.sumarCantidadBarcos() <= 9) {
            vista = 1;
        } else if (tiposDeBarcos.sumarCantidadBarcos() > 9 && tiposDeBarcos.sumarCantidadBarcos() <= 20) {
            vista = 2;
        } else if (tiposDeBarcos.sumarCantidadBarcos() > 20) {
            vista = 3;
        }
        return vista;
    }
    //Final mostrar tablero

    //Inicio de guardar barcoBB por administrador
    public void guardarBarco() {
        try {
            tiposDeBarcos.adicionarNodo(tipoBarco);
            tipoBarco = new TipoBarco();
            pintarArbol();
            pintarArbolN();
        } catch (BatallaNabalExcepcion ex) {
            JsfUtil.addErrorMessage(ex.getMessage());
        }
    }
    //Final de guardar barcoBB por administrador

    //Inicio de metodotos que pintan el arbol
    private DefaultDiagramModel model;

    public void pintarArbol() {

        model = new DefaultDiagramModel();
        model.setMaxConnections(-1);
        model.setConnectionsDetachable(false);
        StraightConnector connector = new StraightConnector();
        connector.setPaintStyle("{strokeStyle:'red', lineWidth:2}");
        connector.setHoverPaintStyle("{strokeStyle:'#20282b'}");
        model.setDefaultConnector(connector);
        pintarArbol(tiposDeBarcos.getRaiz(), model, null, 20, 0);
    }

    private void pintarArbol(NodoABB reco, DefaultDiagramModel model, Element padre, int x, int y) {

        if (reco != null) {
            Element elementHijo = new Element(reco.getDato());

            elementHijo.setX(String.valueOf(x) + "em");
            elementHijo.setY(String.valueOf(y) + "em");
            elementHijo.setId(reco.getDato().getNombre());

            if (padre != null) {
                elementHijo.addEndPoint(new DotEndPoint(EndPointAnchor.TOP));
                DotEndPoint conectorPadre = new DotEndPoint(EndPointAnchor.BOTTOM);
                padre.addEndPoint(conectorPadre);
                model.connect(new Connection(conectorPadre, elementHijo.getEndPoints().get(0)));
            }

            model.addElement(elementHijo);

            pintarArbol(reco.getIzquierda(), model, elementHijo, x - 5, y + 8);
            pintarArbol(reco.getDerecha(), model, elementHijo, x + 5, y + 8);
        }
    }

    public DefaultDiagramModel getModel() {
        return model;
    }
    //Final de metodotos que pintar el arbol
    //
    //Inicio de metodotos que pintar el arbolN
    private DefaultDiagramModel model2;//Variable del vista de la grafica

    public void pintarArbolN() {

        model2 = new DefaultDiagramModel();
        model2.setMaxConnections(-1);
        model2.setConnectionsDetachable(false);//Connexiones modificable
        StraightConnector connector = new StraightConnector();//estilo
        connector.setPaintStyle("{strokeStyle:'red', lineWidth:2}");//estilo
        connector.setHoverPaintStyle("{strokeStyle:'#20282b'}");//estilo
        model2.setDefaultConnector(connector);// los conectores los pinta con estos estilos
        pintarArbolN(tablerojug1.getRaiz(), model2, null, 34, 0);
    }

    private void pintarArbolN(NodoN reco, DefaultDiagramModel model2, Element padre, int x, int y) {
        if (reco != null) {
            Element elementHijo = new Element(reco.getDato());

            elementHijo.setX(String.valueOf(x) + "em");
            elementHijo.setY(String.valueOf(y) + "em");
            elementHijo.setId("" + reco.getDato().getTipoBarco().getCodigo());

            if (padre != null) {
                elementHijo.addEndPoint(new DotEndPoint(EndPointAnchor.TOP));
                DotEndPoint conectorPadre = new DotEndPoint(EndPointAnchor.BOTTOM);
                padre.addEndPoint(conectorPadre);
                model2.connect(new Connection(conectorPadre, elementHijo.getEndPoints().get(0)));
            }
            model2.addElement(elementHijo);

            for (int i = 0; i < reco.getHijos().size(); i++) {
                pintarArbolN(reco.getHijos().get(i), model2, elementHijo, x - 6, y + 6);
                x += 10;
            }
        }
    }

    private EndPoint createEndPoint(EndPointAnchor anchor) {
        DotEndPoint endPoint = new DotEndPoint(anchor);
        endPoint.setStyle("{fillStyle:'#404a4e'}");
        endPoint.setHoverStyle("{fillStyle:'#20282b'}");

        return endPoint;
    }

    public DefaultDiagramModel getModel2() {
        return model2;
    }

    //Final Metodo para pintar ArbolN
    //
    //Inicio de metodo que lee los datos de los barcos 
    public void onClickRight() {
        String id = FacesContext.getCurrentInstance().getExternalContext().getRequestParameterMap().get("elementId");
        barco = id.replaceAll("frmBatalla:diagrama-", "");
        System.out.println("Barco = " + barco); //Solo para realizar pruebas
    }

    private String barco = "";

    //Final de metodo lee datos
    public String getBarco() {
        return barco;
    }

    public void setBarco(String barco) {
        this.barco = barco;
    }
}
