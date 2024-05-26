package JAVARuntime;

// Useful imports
import java.util.*;
import java.text.*;
import java.net.*;
import java.math.*;
import java.io.*;
import java.nio.*;

/**
 * Zee GameDev
*/
public class Porta extends Component { 
private float atualPosicao;
public float abrirPosicao = 90;
public SUIButton button;
private int trocar = 1;
public int velocidade = 5;
public SpatialObject player;
public SpatialObject porta;
public float distancia;
public SpatialObject botao;

    /// Run only once
    @Override
    public void start() {
        
    }

    /// Repeat every frame
    @Override
    public void repeat() {
        if(button.isDown() == true){
            trocar = -1 * trocar;
        }
        if(trocar == -1){
            
            atualPosicao = Math.lerp(atualPosicao,abrirPosicao,velocidade);
            myObject.getTransform().getRotation().setY(atualPosicao);
         } else {
             atualPosicao = Math.lerp(atualPosicao,0.0f,velocidade);
             myObject.getTransform().getRotation().setY(atualPosicao);
        }
        
        distancia = player.getTransform().getPosition().distance(porta.getTransform().getPosition());
        if(distancia <= 1.5f){
            botao.setEnabled(true);
        } else {
            botao.setEnabled(false);
        }
    }

    /// Repeat every frame when component or object is disabled
    @Override
    public void disabledRepeat() {
        
    }
}

