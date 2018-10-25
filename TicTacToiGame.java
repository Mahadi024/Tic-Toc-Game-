/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tictactoigame;



import java.util.ArrayList;
import java.util.Random;
import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Group;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.paint.Color;
import javafx.stage.Stage;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.StackPane;
import javafx.scene.paint.Color;
import javafx.stage.Stage;

/**
 *
 * @author User
 */
public class TicTacToiGame extends Application {
    Button btn1 = new Button();
    Button btn2 = new Button();
    Button btn3 = new Button();
    Button btn4 = new Button();
    Button btn5 = new Button();
    Button btn6 = new Button();
    Button btn7 = new Button();
    Button btn8 = new Button();
    Button btn9 = new Button();
    @Override
    public void start(Stage primaryStage) {
        
        final Image titleScreen = new Image( "title.png" ); //title screen image
 
        final ImageView flashScreen_node = new ImageView();
        flashScreen_node.setImage(titleScreen); //set the image of the title screen
         
        primaryStage.setTitle( "TIC TAC TOI!" );
        //primaryStage.getIcons().add(titleScreen); //stage icon
 
        final double CANVAS_WIDTH = 550;
        final double CANVAS_HEIGHT = 550;
 
        Group root = new Group();
        root.getChildren().addAll(flashScreen_node); //add the title screen to the root
         
        Scene theScene = new Scene( root, CANVAS_WIDTH, CANVAS_HEIGHT, Color.BLACK );
        primaryStage.setScene( theScene );
        primaryStage.show(); 
        ///////////////////////
        btn1.setText(" ");
        btn1.setOnAction(event->{
            playGame(1,btn1);
        });
         
        btn2.setText(" ");
        btn2.setOnAction(event->{
            playGame(2,btn2);
        });
        
        btn3.setText(" ");
        btn3.setOnAction(event->{
            playGame(3,btn3);
        });
         
        btn4.setText(" ");
        btn4.setOnAction(event->{
            playGame(4,btn4);
        });
         
        btn5.setText(" ");
        btn5.setOnAction(event->{
            playGame(5,btn5);
        });
        
        btn6.setText(" ");
        btn6.setOnAction(event->{
            playGame(6,btn6);
        });
        
        btn7.setText(" ");
        btn7.setOnAction(event->{
            playGame(7,btn7);
        });
         
        btn8.setText(" ");
        btn8.setOnAction(event->{
            playGame(8,btn8);
        });
         
        btn9.setText(" ");
        btn9.setOnAction(event->{
            playGame(9,btn9);
        });
        
        GridPane grid = new GridPane();
        grid.setAlignment(Pos.CENTER);
        grid.setHgap(5);
        grid.setVgap(5);
        grid.setPadding(new Insets(50, 50 ,50 ,50));
        
        grid.add(btn1,0,0);
        grid.add(btn2,1,0);
        grid.add(btn3,2,0);
        grid.add(btn4,0,1);
        grid.add(btn5,1,1);
        grid.add(btn6,2,1);
        grid.add(btn7,0,2);
        grid.add(btn8,1,2);
        grid.add(btn9,2,2);
           
        Scene scene = new Scene(grid, 300, 250);
        scene.getStylesheets().add(TicTacToiGame.class.getResource("style.css").toExternalForm());
                
        //primaryStage.setTitle("Tic Toi");
       // primaryStage.setScene(scene);
        //primaryStage.show();
    }
    ArrayList<Integer>player1 =new ArrayList<Integer>();
    ArrayList<Integer>player2 =new ArrayList<Integer>();
    int activePlayer = 1;
    void playGame(int cellId, Button SelectedButton ){
        System.out.println("cellId: "+cellId);
        if(activePlayer == 1){
            SelectedButton.setText("X");
            player1.add(cellId);
            activePlayer = 2;
            //autoPlayer();
        }else if(activePlayer == 2){
            SelectedButton.setText("O");
            player2.add(cellId);
            activePlayer = 1;
        }
        SelectedButton.setDisable(true);
        winGame();
        
       
    }
    void winGame(){
        int winner = -1;
        //Row Check//
        if(player1.contains(1) && player1.contains(2) && player1.contains(3))
        {
            winner = 1;
        }
        if(player2.contains(1) && player2.contains(2) && player2.contains(3))
        {
            winner = 2;
        }
        if(player1.contains(4) && player1.contains(5) && player1.contains(6))
        {
            winner = 1;
        }
        if(player2.contains(4) && player2.contains(5) && player2.contains(6))
        {
            winner = 2;
        }
        if(player1.contains(7) && player1.contains(8) && player1.contains(9))
        {
            winner = 1;
        }
        if(player2.contains(7) && player2.contains(8) && player2.contains(9))
        {
            winner = 2;
        }
        
        //Coloumn Check ////
        
        if(player1.contains(1) && player1.contains(4) && player1.contains(7))
        {
            winner = 1;
        }
         if(player2.contains(1) && player2.contains(4) && player2.contains(7))
        {
            winner = 2;
        }
          if(player1.contains(2) && player1.contains(5) && player1.contains(8))
        {
            winner = 1;
        }
          if(player2.contains(2) && player2.contains(5) && player2.contains(8))
        {
            winner = 2;
        }
          if(player1.contains(3) && player1.contains(6) && player1.contains(9))
        {
            winner = 1;
        }  
         if(player2.contains(3) && player2.contains(6) && player2.contains(9))
        {
            winner = 2;
        }
         
         // Cross Check ///
         
         if(player1.contains(1) && player1.contains(5) && player1.contains(9))
        {
            winner = 1;
        }
         if(player2.contains(1) && player2.contains(5) && player2.contains(9))
        {
            winner = 2;
        }
         if(player1.contains(3) && player1.contains(5) && player1.contains(7))
        {
            winner = 1;
        }
         if(player2.contains(3) && player2.contains(5) && player2.contains(7))
        {
            winner = 2;
        }
         
       // Show Message //
       if(winner != -1)
       {
           String MSG = "";
           if(winner == 1){
               MSG = "Winner is Player 1";
           }
           if(winner == 2){
               MSG = "Winner is Player 2";
           }
           Alert alert = new Alert(Alert.AlertType.INFORMATION);
           alert.setTitle("Game Info");
           alert.setContentText(MSG);
           alert.setHeaderText("Playing Info");
           alert.show();
       }
    }
    void autoPlayer(){
        ArrayList<Integer>emptyCell = new ArrayList<Integer>();
        for(int cell =1; cell<10; cell++)
        {
            if(!(player1.contains(cell)|| player2.contains(cell))){
                emptyCell.add(cell);
            }
        }
        Random r =new Random();
        int RandIndex = r.nextInt(emptyCell.size()-0)+0;
        int cellId = emptyCell.get(RandIndex);
        Button SelectedButton;
        switch(cellId){
            case 1: SelectedButton = btn1;
                break;
            case 2: SelectedButton = btn2;
                break;
            case 3: SelectedButton = btn3;
                break;
            case 4: SelectedButton = btn4;
                break; 
            case 5: SelectedButton = btn5;
                break;    
            case 6: SelectedButton = btn6;
                break;    
            case 7: SelectedButton = btn7;
                break;
            case 8: SelectedButton = btn8;
                break;
            case 9: SelectedButton = btn9;
                break;
            default: SelectedButton = btn1;
        }
        playGame(cellId,SelectedButton);
    }
    

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        launch(args);
    }

    private static class Image {

        public Image(String titlepng) {
        }
    }
    
}
