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
import javax.enterprise.context.ApplicationScoped;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import org.primefaces.PrimeFaces;
import org.primefaces.model.diagram.Connection;
import org.primefaces.model.diagram.DefaultDiagramModel;
import org.primefaces.model.diagram.Element;
import org.primefaces.model.diagram.connector.StraightConnector;
import org.primefaces.model.diagram.endpoint.DotEndPoint;
import org.primefaces.model.diagram.endpoint.EndPointAnchor;

/**
 *
 * @author Santiago Betancur Villegas <santiago-betancur at hotmail.com>
 */
@Named(value = "controladorBatalla")
@ApplicationScoped
public class ControladorBatalla implements Serializable {

    private Usuario administrador;
    private Usuario jugador1;
    private Usuario jugador2;
    private int cantBarcos;
    private ArbolN tablerojug1 = new ArbolN();
    private ArbolN tablerojug2 = new ArbolN();
    private List<Coordenada> disparosjug1 = new ArrayList<>();
    private List<Coordenada> disparosjug2 = new ArrayList<>();
    private ArbolBinarioB tiposDeBarcos = new ArbolBinarioB();
    //Creador por santiagos
    private TipoBarco tipoBarco = new TipoBarco();
    private String usuarios = "";
    int codigo = 0;
    String password = "";
    byte columna = 0;
    byte fila = 0;
    byte columnaJugadorDos = 0;
    byte filaJugadorDos = 0;
    byte disparoColumna = 0;
    byte disparoFila = 0;
    int posicionDeBarco = 0;
    int posicionDeBarcoJugadorDos = 0;
    boolean activarPosicionesJugadorUno = true;
    boolean activarPosicionesJugadorDos = true;
    boolean activarDisparosJugadorUno = false;
    boolean activarDisparosJugadorDos = false;

    //Constructor
    public ControladorBatalla() {
        System.out.println("se inicio un bean de aplication");
    }

    //Setter and Getter
    public boolean isActivarDisparosJugadorUno() {
        return activarDisparosJugadorUno;
    }

    public void setActivarDisparosJugadorUno(boolean activarDisparosJugadorUno) {
        this.activarDisparosJugadorUno = activarDisparosJugadorUno;
    }

    public boolean isActivarDisparosJugadorDos() {
        return activarDisparosJugadorDos;
    }

    public void setActivarDisparosJugadorDos(boolean activarDisparosJugadorDos) {
        this.activarDisparosJugadorDos = activarDisparosJugadorDos;
    }

    public int getPosicionDeBarcoJugadorDos() {
        return posicionDeBarcoJugadorDos;
    }

    public void setPosicionDeBarcoJugadorDos(int posicionDeBarcoJugadorDos) {
        this.posicionDeBarcoJugadorDos = posicionDeBarcoJugadorDos;
    }

    public byte getColumnaJugadorDos() {
        return columnaJugadorDos;
    }

    public void setColumnaJugadorDos(byte columnaJugadorDos) {
        this.columnaJugadorDos = columnaJugadorDos;
    }

    public byte getFilaJugadorDos() {
        return filaJugadorDos;
    }

    public void setFilaJugadorDos(byte filaJugadorDos) {
        this.filaJugadorDos = filaJugadorDos;
    }

    public boolean isActivarPosicionesJugadorDos() {
        return activarPosicionesJugadorDos;
    }

    public void setActivarPosicionesJugadorDos(boolean activarPosicionesJugadorDos) {
        this.activarPosicionesJugadorDos = activarPosicionesJugadorDos;
    }

    public boolean isActivarPosicionesJugadorUno() {
        return activarPosicionesJugadorUno;
    }

    public void setActivarPosicionesJugadorUno(boolean activarPosicionesJugadorUno) {
        this.activarPosicionesJugadorUno = activarPosicionesJugadorUno;
    }

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
        administrador = new Usuario("admin@hotmail.com", "Colombia12", new Rol((byte) 4040, "ADMIN"));
        jugador1 = new Usuario("jugador1@hotmail.com", "Colombia12", new Rol((byte) 2020, "JUGADOR1"));
        jugador2 = new Usuario("jugador2@hotmail.com", "Colombia12", new Rol((byte) 1010, "JUGADOR2"));
        try {
            tiposDeBarcos.adicionarNodo(new TipoBarco("Fragata", (byte) 5, (byte) 2));
            tiposDeBarcos.adicionarNodo(new TipoBarco("Rompe", (byte) 6, (byte) 1));
//            tiposDeBarcos.adicionarNodo(new TipoBarco("Acorazado", (byte) 4, (byte) 1));
//            tiposDeBarcos.adicionarNodo(new TipoBarco("Destructor", (byte) 1, (byte) 2));
            tiposDeBarcos.adicionarNodo(new TipoBarco("Submarino", (byte) 7, (byte) 2));
        } catch (BatallaNabalExcepcion ex) {
            JsfUtil.addErrorMessage(ex.getMessage());
        }
        cargarArbolJugadorUno();
        cargarArbolJugadorDos();
        pintarArbol();
        pintarArbolN();
        pintarArbolNJugadorDos();
    }

    //Inicio de adicionar barcosN aparatir del arbolBB
    public void cargarArbolJugadorUno() {
        //Algoritmo
        tablerojug1.adicionarNodo(new BarcoPosicionado(new TipoBarco("yo", (byte) 0), 0), null);
        List<BarcoPosicionado> padres = new ArrayList<>();
        padres.add(tablerojug1.getRaiz().getDato());
        adicionarPreOrdenJugadorUno(tiposDeBarcos.getRaiz(), padres, 0, 0);
//            System.out.println("Cantidad: " + contAbb.getArbol().getCantidadNodos());PRUEBASS
    }

    private void adicionarPreOrdenJugadorUno(NodoABB reco, List<BarcoPosicionado> padres, int contizq, int contder) {
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

            adicionarPreOrdenJugadorUno(reco.getIzquierda(), padresNuevos, contizq, contder);

            contizq = contizq + tiposDeBarcos.sumarCantidadBarcos(reco.getIzquierda());

            adicionarPreOrdenJugadorUno(reco.getDerecha(), padresNuevos, contizq, contder);
        }
    }

    //Final de adicionar barcosN aparatir del arbolBB
    //Inicio de adicionar barcosN aparatir del arbolBB
    public void cargarArbolJugadorDos() {
        //Algoritmo
        tablerojug2.adicionarNodo(new BarcoPosicionado(new TipoBarco("yo", (byte) 0), 0), null);
        List<BarcoPosicionado> padres = new ArrayList<>();
        padres.add(tablerojug2.getRaiz().getDato());
        adicionarPreOrdenJugadorDos(tiposDeBarcos.getRaiz(), padres, 0, 0);
//            System.out.println("Cantidad: " + contAbb.getArbol().getCantidadNodos());PRUEBASS
    }

    private void adicionarPreOrdenJugadorDos(NodoABB reco, List<BarcoPosicionado> padres, int contizq, int contder) {
        if (reco != null) {
            List<BarcoPosicionado> padresNuevos = new ArrayList<>();
            int contPapas = 0;
            for (byte i = 0; i < reco.getDato().getCantidadJuego(); i++) {
                BarcoPosicionado barcoNuevo = new BarcoPosicionado(new TipoBarco(reco.getDato().getNombre(), reco.getDato().getNroCasillas()), reco.getDato().getCodigo());
                barcoNuevo.getTipoBarco().setCodigo(++contizq);
                if (contPapas >= padres.size()) {
                    contPapas = 0;
                }
                tablerojug2.adicionarNodoxCodigo(barcoNuevo, padres.get(contPapas));
                padresNuevos.add(barcoNuevo);
                contPapas++;
            }
            //Validar nuevo codigo          
            contizq = contizq + contder;

            adicionarPreOrdenJugadorDos(reco.getIzquierda(), padresNuevos, contizq, contder);

            contizq = contizq + tiposDeBarcos.sumarCantidadBarcos(reco.getIzquierda());

            adicionarPreOrdenJugadorDos(reco.getDerecha(), padresNuevos, contizq, contder);
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
        try {
            int cantidad = 0;
            cantidad = mostrarTableroJava();
            if (barco.equals("")) {
            } else {
                tablerojug1.buscarBarcoSeleccionado(Integer.parseInt(barco), columna, fila, posicionDeBarco, cantidad);
                pintarArbolN();
                contarLasCoor();
                contarLosNombresDeCoor();

            }
        } catch (BatallaNabalExcepcion ex) {
            JsfUtil.addErrorMessage(ex.getMessage());
        }
    }

    public void addCoordenadasJugadorDos() {
        try {
            int cantidad = 0;
            cantidad = mostrarTableroJava();
            if (barco.equals("")) {
            } else {
                tablerojug2.buscarBarcoSeleccionado(Integer.parseInt(barco), columnaJugadorDos, filaJugadorDos, posicionDeBarcoJugadorDos, cantidad);
                pintarArbolNJugadorDos();
                contarLasCoorJugadorDos();
                contarLosNombresDeCoorJugadorDos();
            }
//            JsfUtil.addSuccessMessage("Se adionaron Coordenadas en barco: " + barco);
        } catch (BatallaNabalExcepcion ex) {
            JsfUtil.addErrorMessage(ex.getMessage());
        }
    }

    public void pruebaDatosCoorSimples() {
        tablerojug1.datosCoorSimples();
    }

    public void indicarPosiciones() {
        adicionarCoordenadas = adicionarPosiciones();
    }

    private String adicionarCoordenadas = "";

    public String getAdicionarCoordenadas() {
        return adicionarCoordenadas;
    }

    public void setAdicionarCoordenadas(String adicionarCoordenadas) {
        this.adicionarCoordenadas = adicionarCoordenadas;
    }

    //Final de coordenas
    //Inicio que me ayuda a colocar posiciones en el tablero
    private String adicionarPosiciones() {
        String coordenada = Arrays.toString(tablerojug1.agregarCoordenadas());
        return coordenada;
    }

    public void disparar() {
        disparoJugadorUno();
    }

    public String disparoJugadorUno() {
        String disparo = "";
        disparo = disparoColumna + "," + disparoFila;
        return disparo;
    }

    //Final que me ayuda a colocar posiciones en el tablero
    //Inicio mostrar tablero -----JAVASCRIPT
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
            pintarArbolNJugadorDos();
        } catch (BatallaNabalExcepcion ex) {
            JsfUtil.addErrorMessage(ex.getMessage());
        }
    }
    //Final de guardar barcoBB por administrador

    //Inicio de metodotos que pintan el arbolBB
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
    //Inicio de metodotos que pintar el arbolNJugadorUno
    private DefaultDiagramModel model2;//Variable del vista de la grafica

    public void pintarArbolN() {

        model2 = new DefaultDiagramModel();
        model2.setMaxConnections(-1);
        model2.setConnectionsDetachable(false);//Connexiones modificable
        StraightConnector connector = new StraightConnector();//estilo
        connector.setPaintStyle("{strokeStyle:'red', lineWidth:2}");//estilo
        connector.setHoverPaintStyle("{strokeStyle:'#20282b'}");//estilo
        model2.setDefaultConnector(connector);// los conectores los pinta con estos estilos
        pintarArbolN(tablerojug1.getRaiz(), model2, null, 18, 0);
    }

    private void pintarArbolN(NodoN reco, DefaultDiagramModel model2, Element padre, int x, int y) {
        if (reco != null) {
            Element elementHijo = new Element(reco.getDato());
            switch (reco.getDato().getTipoBarco().getNombre()) {
                case "yo":
                    elementHijo.setStyleClass("ui-diagram-black");
                    break;
                case "Fragata":
                    elementHijo.setStyleClass("ui-diagram-fragata");
                    break;
                case "Submarino":
                    elementHijo.setStyleClass("ui-diagram-submarino");
                    break;
                case "Rompe":
                    elementHijo.setStyleClass("ui-diagram-rompe");
                    break;
                default:
                    break;
            }
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
                y += 1;
            }
        }
    }

    public DefaultDiagramModel getModel2() {
        return model2;
    }

    //Final Metodo para pintar ArbolN
    //Inicio de metodotos que pintar el arbolNJugadorDos
    private DefaultDiagramModel model3;//Variable del vista de la grafica

    public void pintarArbolNJugadorDos() {

        model3 = new DefaultDiagramModel();
        model3.setMaxConnections(-1);
        model3.setConnectionsDetachable(false);//Connexiones modificable
        StraightConnector connector = new StraightConnector();//estilo
        connector.setPaintStyle("{strokeStyle:'red', lineWidth:2}");//estilo
        connector.setHoverPaintStyle("{strokeStyle:'#20282b'}");//estilo
        model3.setDefaultConnector(connector);// los conectores los pinta con estos estilos
        pintarArbolNJugadorDos(tablerojug2.getRaiz(), model3, null, 18, 0);
    }

    private void pintarArbolNJugadorDos(NodoN reco, DefaultDiagramModel model3, Element padre, int x, int y) {
        if (reco != null) {
            Element elementHijo = new Element(reco.getDato());
            switch (reco.getDato().getTipoBarco().getNombre()) {
                case "yo":
                    elementHijo.setStyleClass("ui-diagram-black");
                    break;
                case "Fragata":
                    elementHijo.setStyleClass("ui-diagram-fragata");
                    break;
                case "Submarino":
                    elementHijo.setStyleClass("ui-diagram-submarino");
                    break;
                case "Rompe":
                    elementHijo.setStyleClass("ui-diagram-rompe");
                    break;
                default:
                    break;
            }
            elementHijo.setX(String.valueOf(x) + "em");
            elementHijo.setY(String.valueOf(y) + "em");
            elementHijo.setId("" + reco.getDato().getTipoBarco().getCodigo());

            if (padre != null) {
                elementHijo.addEndPoint(new DotEndPoint(EndPointAnchor.TOP));
                DotEndPoint conectorPadre = new DotEndPoint(EndPointAnchor.BOTTOM);
                padre.addEndPoint(conectorPadre);
                model3.connect(new Connection(conectorPadre, elementHijo.getEndPoints().get(0)));
            }
            model3.addElement(elementHijo);

            for (int i = 0; i < reco.getHijos().size(); i++) {
                pintarArbolNJugadorDos(reco.getHijos().get(i), model3, elementHijo, x - 6, y + 6);
                x += 10;
                y += 1;
            }
        }
    }

    public DefaultDiagramModel getModel3() {
        return model3;
    }

    //Final Metodo para pintar ArbolNJugador dos
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

    //Metodos creados para el tableros Nuevos
    //Inicio mostrar tablero
    public int mostrarTableroJava() {
        int vista = 0;
        if (tiposDeBarcos.sumarCantidadBarcos() <= 9) {
            vista = 10;
        } else if (tiposDeBarcos.sumarCantidadBarcos() > 9 && tiposDeBarcos.sumarCantidadBarcos() <= 20) {
            vista = 20;
        } else if (tiposDeBarcos.sumarCantidadBarcos() > 20) {
            vista = 30;
        }
        return vista;
    }
    //Final mostrar tablero

    //Inicio de verificarTurnos
    public void showMessageJugadorDos() {
        FacesMessage message = new FacesMessage(FacesMessage.SEVERITY_INFO, "En espera de Turno", "Cargando...");
        PrimeFaces.current().dialog().showMessageDynamic(message);
    }
    //Final de verificar turno    

    //Inicio verificar disparo j1
    public boolean verificarDisparoJugadorUno(int columna, int fila) {
        for (Coordenada disparo : disparosjug1) {
            if (disparo.getFila() == fila && disparo.getColumna() == columna) {
                return true;
            }
        }
        return false;
    }
    //Final  verificar disparo
    private List<Coordenada> cordsOcupadas = new ArrayList<>();

    private boolean turnoJug1 = true;
    private boolean turnoJug2 = false;

    public boolean isTurnoJug1() {
        return turnoJug1;
    }

    public void setTurnoJug1(boolean turnoJug1) {
        this.turnoJug1 = turnoJug1;
    }

    public boolean isTurnoJug2() {
        return turnoJug2;
    }

    public void setTurnoJug2(boolean turnoJug2) {
        this.turnoJug2 = turnoJug2;
    }

    //Inicio de almacenar diaparos j1
    public void dispararJugadorUno(int columna, int fila) { //accion de guardar coorJ1
        if (turnoJug1) {
            JsfUtil.addSuccessMessage("Disparo Guardado: " + columna + "." + fila);
            disparosjug1.add(new Coordenada((byte) columna, (byte) fila));
            cordsOcupadas = tablerojug2.acumCoordenadas();
            int num = 0;
            for (Coordenada coor : cordsOcupadas) {
                if (coor.getFila() == fila && coor.getColumna() == columna) {
                    num++;
                    pegadosjug1++;
                }
            }
            if (validarGanadorjug1()) {
                FacesMessage message = new FacesMessage(FacesMessage.SEVERITY_INFO, "...Ganaste...", "...Campeón...");
                PrimeFaces.current().dialog().showMessageDynamic(message);
            }
            if (num < 1) {
                turnoJug1 = false;
                turnoJug2 = true;
                FacesMessage message = new FacesMessage(FacesMessage.SEVERITY_INFO, "Fallaste este Turno", "Intenta de nuevo... ");
                PrimeFaces.current().dialog().showMessageDynamic(message);
            }
        } else {
            FacesMessage message = new FacesMessage(FacesMessage.SEVERITY_INFO, "Información...", "Aún no te toca, Jugador dos no ha perdido, Sigue intentando");
            PrimeFaces.current().dialog().showMessageDynamic(message);
//            JsfUtil.addErrorMessage("aun no le toca intente de nuevo en un momento");
        }

    }
//Final de almacenar diaparos
    int pegadosjug1 = 0;
    int pegadosjug2 = 0;

    public boolean validarGanadorjug1() {
        cordsOcupadas = tablerojug2.acumCoordenadas();
        return pegadosjug1 == cordsOcupadas.size();
    }

    public boolean validarGanadorjug2() {
        cordsOcupadas = tablerojug1.acumCoordenadas();
        return pegadosjug2 == cordsOcupadas.size();
    }

//Inicio de almacenar diaparos j2
    public void dispararJugadorDos(int columna, int fila) {
        if (turnoJug2) {
            JsfUtil.addSuccessMessage("Disparo Guardado: " + columna + "." + fila);
            disparosjug2.add(new Coordenada((byte) columna, (byte) fila));
            cordsOcupadas = tablerojug1.acumCoordenadas();
            int num = 0;
            for (Coordenada coor : cordsOcupadas) {
                if (coor.getFila() == fila && coor.getColumna() == columna) {
                    num++;
                    pegadosjug2++;
                }

            }
            if (validarGanadorjug2()) {
                FacesMessage message = new FacesMessage(FacesMessage.SEVERITY_INFO, "...Ganaste...", "...Campeón...");
                PrimeFaces.current().dialog().showMessageDynamic(message);
            }
            if (num < 1) {
                turnoJug1 = true;
                turnoJug2 = false;
                FacesMessage message = new FacesMessage(FacesMessage.SEVERITY_INFO, "Fallaste este Turno", "Intenta de nuevo... ");
                PrimeFaces.current().dialog().showMessageDynamic(message);

            }
        } else {
            FacesMessage message = new FacesMessage(FacesMessage.SEVERITY_INFO, "Información...", "Aún no te toca, Jugador uno no ha perdido, Sigue intentando");
            PrimeFaces.current().dialog().showMessageDynamic(message);
//            JsfUtil.addErrorMessage("aun no le toca intente de nuevo en un momento");
        }

    }
    //Final de almacenar diaparos

    public String mostrarTruno(boolean estado) {
        String dato = "";
        if (estado == true) {
            dato = "Espera...";
        } else {
            dato = "Continua...";
        }
        return dato;
    }

    //Inicio de pintar disparos
    public String pintarDisparosJugadorUno(int columna, int fila) {
        for (Coordenada disparo : disparosjug1) {
            for (BarcoPosicionado miBarquito : tablerojug2.listarNodos()) {
                if (miBarquito.getCoordenadas() != null) {
                    if (miBarquito.validarCoordenada(disparo.getColumna(), disparo.getFila())) {
                        if (disparo.getFila() == fila && disparo.getColumna() == columna) {
                            return "background-image: url('../imagenes/barcotocado.jpg'); background-size: cover;";
                        }
                    }
                }
            }
        }
        return "width: 100px; height: 30px";
    }
    //Final de pintar disparos

    //Inicio verificar disparo j2
    public boolean verificarDisparoJugadorDos(int columna, int fila) {
        for (Coordenada disparo : disparosjug2) {
            if (disparo.getFila() == fila && disparo.getColumna() == columna) {
                return true;
            }
        }
        return false;
    }
    //Final  verificar disparo

    //Inicio de pintar disparos j2
    public String pintarDisparosJugadorDos(int columna, int fila) {
        for (Coordenada disparo : disparosjug2) {
            for (BarcoPosicionado miBarquito : tablerojug1.listarNodos()) {
                if (miBarquito.getCoordenadas() != null) {
                    if (miBarquito.validarCoordenada(disparo.getColumna(), disparo.getFila())) {
                        if (disparo.getFila() == fila && disparo.getColumna() == columna) {
                            return "background-image: url('../imagenes/barcotocado.jpg'); background-size: cover;";
                        }
                    }
                }
            }
        }
        return "width: 100px; height: 30px";
    }
    //Final de pintar disparos j2

//    public String pintarBarcos(int columna, int fila) {
//        if (validarCoordenada(tablerojug1.getRaiz(), columna, fila)) {
//            switch (mirarTamaDeBarco()) {
//                case "<":
//                    contarImagen++;
//                    return "background-image: url('../imagenes/submarino.png'); background-size: cover;";
//                case "=":
//                    contarImagen++;
//                    return "background-image: url('../imagenes/fragata.jpg'); background-size: cover;";
//                case ">":
//                    contarImagen = 0;
//                    return "background-image: url('../imagenes/submarino.png'); background-size: cover;";
//                default:
//                    JsfUtil.addSuccessMessage("Este dato.");
//            }
//        }
//        return "width: 100px; height: 30px";
//    }
//    private String pintarDisJuga2 = "";
//    private String pintarDisparosJugadorUno(int columna, int fila) {
//        for (BarcoPosicionado miBarquito : tablerojug2.listarNodos()) {
//            if (miBarquito.getCoordenadas() != null) {
//                if (miBarquito.validarCoordenada(columna, fila)) {
//                    pintarDisJuga2 = "background-color: blue;";
//                }
//            }
//            break;
//        }
//        return "width: 100px; height: 30px";
//    }
    public String pintarBarcos(int columna, int fila) {
        for (BarcoPosicionado miBarquito : tablerojug1.listarNodos()) {
            if (miBarquito.getCoordenadas() != null) {
                if (miBarquito.validarCoordenada(columna, fila)) {
                    if (miBarquito.getTipoBarco().getNombre().compareTo("Fragata") == 0) {
                        return "background-image: url('../imagenes/fragata.jpg'); background-size: cover;";
                    } else if (miBarquito.getTipoBarco().getNombre().compareTo("Submarino") == 0) {
                        return "background-image: url('../imagenes/submarino.png'); background-size: cover;";
                    } else if (miBarquito.getTipoBarco().getNombre().compareTo("Rompe") == 0) {
                        return "background-image: url('../imagenes/rompe.jpg'); background-size: cover;";
                    }
                }
            }
        }
        return "width: 100px; height: 30px";
    }

    public String pintarBarcosJugadorDos(int columna, int fila) {
        for (BarcoPosicionado miBarquito : tablerojug2.listarNodos()) {
            if (miBarquito.getCoordenadas() != null) {
                if (miBarquito.validarCoordenada(columna, fila)) {
                    if (miBarquito.getTipoBarco().getNombre().compareTo("Fragata") == 0) {
                        return "background-image: url('../imagenes/fragata.jpg'); background-size: cover;";
                    } else if (miBarquito.getTipoBarco().getNombre().compareTo("Submarino") == 0) {
                        return "background-image: url('../imagenes/submarino.png'); background-size: cover;";
                    } else if (miBarquito.getTipoBarco().getNombre().compareTo("Rompe") == 0) {
                        return "background-image: url('../imagenes/rompe.jpg'); background-size: cover;";
                    }
                }
            }
        }
        return "width: 100px; height: 30px";
    }

    public boolean validarCoordenada(NodoN reco, int columna, int fila) {
        if (reco != null) {
            if (reco.getDato().getTipoBarco().getCodigo() != 0 && reco.getDato().validarCoordenada(columna, fila)) {
                return true;
            } else {
                for (NodoN hijo : reco.getHijos()) {
                    if (validarCoordenada(hijo, columna, fila)) {
                        return true;
                    }
                }
            }
        }
        return false;
    }

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

    public void autenticarCoordenadasJuUno() {
        if (datosCoo.size() == tiposDeBarcos.sumarCantidadBarcos() && datosCooJugadorDos.size() == tiposDeBarcos.sumarCantidadBarcos()) {
            JsfUtil.addSuccessMessage("Que comience el juego");
            activarDisparosJugadorUno = true;
        } else {
            JsfUtil.addSuccessMessage("Jugador Dos aun sin posicionar");
        }
    }

    public void autenticarCoordenadasJuDos() {
        if (datosCoo.size() == tiposDeBarcos.sumarCantidadBarcos() && datosCooJugadorDos.size() == tiposDeBarcos.sumarCantidadBarcos()) {
            JsfUtil.addSuccessMessage("Que comience el juego");
            activarDisparosJugadorDos = true;
        } else {
            JsfUtil.addSuccessMessage("Jugador Uno aun sin posicionar");
        }
    }

    //Inico de conteo de las coor
    private boolean desactiAdicionarJuUno = true;

    public boolean isDesactiAdicionarJuUno() {
        return desactiAdicionarJuUno;
    }

    public void setDesactiAdicionarJuUno(boolean desactiAdicionarJuUno) {
        this.desactiAdicionarJuUno = desactiAdicionarJuUno;
    }

    private ArrayList coordenadas;

    public ArrayList getCoordenadas() {
        return coordenadas;
    }

    public void setCoordenadas(ArrayList coordenadas) {
        this.coordenadas = coordenadas;
    }

    ArrayList datosCoo = new ArrayList<>();

    public void contarLasCoor() {
        if (datosCoo.size() < tiposDeBarcos.sumarCantidadBarcos()) {
            datosCoo.add(datosDeNodosCoo(new ArrayList()));
            coordenadas = datosCoo;
            if (datosCoo.size() == tiposDeBarcos.sumarCantidadBarcos()) {
                JsfUtil.addSuccessMessage("Presiona LISTO y Valida tu oponente");
                desactiAdicionarJuUno = false;
            }
        } else {
            JsfUtil.addSuccessMessage("Nose tiene mas coordenadas diponible, editelas");
        }
    }

    public ArrayList datosDeNodosCoo(ArrayList lista) {
        Coordenada[] coorActual = tablerojug1.agregarCoordenadas();
        lista.add(Arrays.toString(coorActual));
        return lista;
    }

    private ArrayList nombreDeCoordenadas;

    public ArrayList getNombreDeCoordenadas() {
        return nombreDeCoordenadas;
    }

    public void setNombreDeCoordenadas(ArrayList nombreDeCoordenadas) {
        this.nombreDeCoordenadas = nombreDeCoordenadas;
    }

    ArrayList datosNombreCoo = new ArrayList<>();

    public void contarLosNombresDeCoor() {
        if (datosNombreCoo.size() < tiposDeBarcos.sumarCantidadBarcos()) {
            datosNombreCoo.add(datosDeNombres(new ArrayList()));
            nombreDeCoordenadas = datosNombreCoo;
        } else {
            JsfUtil.addSuccessMessage("Nose tiene mas coordenadas diponible, editelas");
        }
    }

    public ArrayList datosDeNombres(ArrayList lista) {
        String nombre = tablerojug1.buscarNombreDeBarco(Integer.parseInt(barco), tablerojug1.getRaiz());
        lista.add(nombre);
        return lista;
    }
    //Final de conteo de las coor

    //Inico de conteo de las coor
    private boolean desactiAdicionarJuDos = true;

    public boolean isDesactiAdicionarJuDos() {
        return desactiAdicionarJuDos;
    }

    public void setDesactiAdicionarJuDos(boolean desactiAdicionarJuDos) {
        this.desactiAdicionarJuDos = desactiAdicionarJuDos;
    }

    private ArrayList coordenadasJugadorDos;

    public ArrayList getCoordenadasJugadorDos() {
        return coordenadasJugadorDos;
    }

    public void setCoordenadasJugadorDos(ArrayList coordenadasJugadorDos) {
        this.coordenadasJugadorDos = coordenadasJugadorDos;
    }

    ArrayList datosCooJugadorDos = new ArrayList<>();

    public void contarLasCoorJugadorDos() {
        if (datosCooJugadorDos.size() < tiposDeBarcos.sumarCantidadBarcos()) {
            datosCooJugadorDos.add(datosDeNodosCooJugadorDos(new ArrayList()));
            coordenadasJugadorDos = datosCooJugadorDos;
            if (datosCooJugadorDos.size() == tiposDeBarcos.sumarCantidadBarcos()) {
                JsfUtil.addSuccessMessage("Presiona LISTO y Valida tu oponente");
                desactiAdicionarJuDos = false;
            }
        } else {
            JsfUtil.addSuccessMessage("Nose tiene mas coordenadas diponible, editelas");
        }
    }

    public ArrayList datosDeNodosCooJugadorDos(ArrayList lista) {
        Coordenada[] coorActual = tablerojug2.agregarCoordenadas();
        lista.add(Arrays.toString(coorActual));
        return lista;
    }

    private ArrayList nombreDeCoordenadasJugadorDos;

    public ArrayList getNombreDeCoordenadasJugadorDos() {
        return nombreDeCoordenadasJugadorDos;
    }

    public void setNombreDeCoordenadasJugadorDos(ArrayList nombreDeCoordenadasJugadorDos) {
        this.nombreDeCoordenadasJugadorDos = nombreDeCoordenadasJugadorDos;
    }

    ArrayList datosNombreCooJugadorDos = new ArrayList<>();

    public void contarLosNombresDeCoorJugadorDos() {
        if (datosNombreCooJugadorDos.size() < tiposDeBarcos.sumarCantidadBarcos()) {
            datosNombreCooJugadorDos.add(datosDeNombresJugadorDos(new ArrayList()));
            nombreDeCoordenadasJugadorDos = datosNombreCooJugadorDos;
        } else {
            JsfUtil.addSuccessMessage("Nose tiene mas coordenadas diponible, editelas");
        }
    }

    public ArrayList datosDeNombresJugadorDos(ArrayList lista) {
        String nombre = tablerojug2.buscarNombreDeBarco(Integer.parseInt(barco), tablerojug2.getRaiz());
        lista.add(nombre);
        return lista;
    }
    //Final de conteo de las coor

    private String cambio = "";
    private int contarImagen = 0;

    public String mirarTamaDeBarco() {///prueba
        String cadena = tablerojug1.verificarImagen();
//        System.out.println("PRUEBABEAN: " + cadena);
        String[] arr = cadena.split(",");
        for (; contarImagen < arr.length;) {
            cambio = arr[contarImagen];
            break;
        }
        return cambio;
    }

    public boolean validarPosActual(int c, int f) {
        Coordenada[] coorActual = tablerojug1.agregarCoordenadas();
        for (int i = 0; i < coorActual.length; i++) {
            if (coorActual[i].getColumna() == c && coorActual[i].getFila() == f) {
                return true;
            }
        }
        return false;
    }

    public void pruebaDeCoordenadas() {
        if (pruebaDeCoordenadas(tablerojug1.getRaiz(), disparoColumna, disparoFila)) {
            JsfUtil.addSuccessMessage("Coordenada encontrada");
        } else {
            JsfUtil.addSuccessMessage("Coordenada No encontrada");
        }
    }

    private boolean pruebaDeCoordenadas(NodoN reco, int disparoColumna, int disparoFila) {
        if (reco != null) {
            if (reco.getDato().getTipoBarco().getCodigo() != 0 && reco.getDato().validarCoordenada(disparoColumna, disparoFila)) {
                return true;
            } else {
                for (NodoN hijo : reco.getHijos()) {
                    if (pruebaDeCoordenadas(hijo, disparoColumna, disparoFila)) {
                        return true;
                    }
                }
            }
        }
        return false;
    }

    public void pruebaDeCoordenadasJugadorDos() {
        if (pruebaDeCoordenadasJugadorDos(tablerojug2.getRaiz(), disparoColumna, disparoFila)) {
            JsfUtil.addSuccessMessage("Coordenada encontrada");
        } else {
            JsfUtil.addSuccessMessage("Coordenada No encontrada");
        }
    }

    private boolean pruebaDeCoordenadasJugadorDos(NodoN reco, int disparoColumna, int disparoFila) {
        if (reco != null) {
            if (reco.getDato().getTipoBarco().getCodigo() != 0 && reco.getDato().validarCoordenada(disparoColumna, disparoFila)) {
                return true;
            } else {
                for (NodoN hijo : reco.getHijos()) {
                    if (pruebaDeCoordenadas(hijo, disparoColumna, disparoFila)) {
                        return true;
                    }
                }
            }
        }
        return false;
    }
}
