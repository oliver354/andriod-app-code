package application;
import java.util.*;
import javafx.application.Application;
import javafx.scene.*;
import javafx.scene.control.*;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.*;
import javafx.scene.paint.*;
import javafx.scene.shape.Circle;
import javafx.stage.Stage;
public class Pushbox extends Application {
	private double width = 32*20;
	private double height = 32*20;
	private int[][] grid;
	private int[][] targets;
	private Image manPic = new Image("file:res/man.png");
	private Image box  = new Image("file:res/box.png");
	private Image stone = new Image("file:res/stone.png");
	private Pane warehouse = new Pane();
	private ArrayList<ImageView> boxList;
	private ImageView man;

	public void start(Stage primaryStage) {
		//建立界面
		MenuBar menuBar = new MenuBar();
		Menu menu1 = new Menu("Tool");
		menuBar.getMenus().add(menu1);
		MenuItem menu12 = new MenuItem("Reset");
		menu1.getItems().add(menu12);
		warehouseInitialize();
		VBox vBox = new VBox(menuBar,warehouse);
		vBox.setBackground(new Background(new BackgroundFill(Color.rgb(169,169,169),null,null)));
		Scene scene = new Scene(vBox,800,800);
		//事件设置
		scene.setOnKeyPressed(e->{
			switch(e.getCode()){
			case W: goUp(); break;
			case S: goDown(); break;
			case A: goLeft(); break;
			case D: goRight(); break;
			}
			isWin();
		});

		menu12.setOnAction(e->{
			warehouseInitialize();
		});

		primaryStage.setScene(scene);
		primaryStage.setTitle("BoxMan");
		primaryStage.setWidth(width);
		primaryStage.setHeight(height+menuBar.getHeight()+64);
		primaryStage.setResizable(false);
		primaryStage.show();
	}

	public static void main(String[] args) {
		launch(args);
	}
	//上下左右四个方向移动
	public void goUp(){
		int row = (int) (man.getY()/32);
		int col = (int) (man.getX()/32);
		if(grid[row-1][col]==1){
			return;
		}else if(grid[row-1][col]==0){
			man.setY((row-1)*32);
		}else if(grid[row-1][col]==2){
			if(grid[row-2][col]==0){
				ImageView box = findBox(row-1,col);
				box.setY((row-2)*32);
				man.setY((row-1)*32);
				grid[row-2][col]=2;
				grid[row-1][col]=0;

			}else{
				return;
			}
		}
	}

	public void goDown(){
		int row = (int) (man.getY()/32);
		int col = (int) (man.getX()/32);
		if(grid[row+1][col]==1){
			return;
		}else if(grid[row+1][col]==0){
			man.setY((row+1)*32);
		}else if(grid[row+1][col]==2){
			if(grid[row+2][col]==0){
				ImageView box = findBox(row+1,col);
				box.setY((row+2)*32);
				man.setY((row+1)*32);
				grid[row+2][col]=2;
				grid[row+1][col]=0;
			}else{
				return;
			}
		}
	}

	public void goLeft(){
		int row = (int) (man.getY()/32);
		int col = (int) (man.getX()/32);
		if(grid[row][col-1]==1){
			return;
		}else if(grid[row][col-1]==0){
			man.setX((col-1)*32);
		}else if(grid[row][col-1]==2){
			if(grid[row][col-2]==0){
				ImageView box = findBox(row,col-1);
				box.setX((col-2)*32);
				man.setX((col-1)*32);
				grid[row][col-2]=2;
				grid[row][col-1]=0;
			}else{
				return;
			}
		}
	}

	public void goRight(){
		int row = (int) (man.getY()/32);
		int col = (int) (man.getX()/32);
		if(grid[row][col+1]==1){
			return;
		}else if(grid[row][col+1]==0){
			man.setX((col+1)*32);
		}else if(grid[row][col+1]==2){
			if(grid[row][col+2]==0){
				ImageView box = findBox(row,col+1);
				box.setX((col+2)*32);
				man.setX((col+1)*32);
				grid[row][col+2]=2;
				grid[row][col+1]=0;
			}else{
				return;
			}
		}
	}

	//面板初始
	public void warehouseInitialize(){
		warehouse.getChildren().clear();
		boxList = new ArrayList<ImageView>();
		man = new ImageView(manPic);
		//warehouse.setBackground();
		int[][] tempGrid = {{1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1},
							{1,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,1},
							{1,0,0,0,0,0,0,1,1,1,0,0,0,0,0,0,0,0,0,1},
							{1,0,0,0,0,0,0,0,0,0,1,0,0,0,0,0,0,0,0,1},
							{1,0,0,0,0,0,0,0,0,0,1,0,0,0,0,0,0,0,0,1},
							{1,0,0,2,0,0,0,0,0,0,1,0,0,0,0,0,0,0,0,1},
							{1,0,0,0,0,0,0,0,0,0,1,0,0,0,0,0,0,0,0,1},
							{1,0,0,0,0,0,0,0,0,0,1,0,0,0,0,0,0,0,0,1},
							{1,0,0,0,0,0,0,0,0,0,1,0,0,0,0,0,0,0,0,1},
							{1,0,0,0,0,0,0,0,0,0,1,0,0,0,2,0,0,0,0,1},
							{1,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,1},
							{1,0,0,0,1,1,0,0,0,0,0,0,0,0,0,0,0,0,0,1},
							{1,0,0,1,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,1},
							{1,0,0,1,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,1},
							{1,0,0,1,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,1},
							{1,0,0,0,1,1,1,0,0,0,0,0,0,0,0,0,0,0,0,1},
							{1,0,0,0,0,0,0,0,0,0,2,0,0,0,0,0,0,0,0,1},
							{1,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,1},
							{1,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,1},
							{1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1}};

		this.grid = tempGrid;
		int[][] tempTargets ={{3,3},{18,18},{16,5}};
		this.targets = tempTargets;
		man.setX(10*32);
		man.setY(10*32);
		warehouse.getChildren().add(man);
		for(int row=0;row<20;row++){
			for(int col=0;col<20;col++){
				if(grid[row][col] == 1){
					ImageView temp = new ImageView(stone);
					temp.setX(col*32);
					temp.setY(row*32);
					warehouse.getChildren().add(temp);
				}else if(grid[row][col] == 2){
					ImageView temp = new ImageView(box);
					temp.setX(col*32);
					temp.setY(row*32);
					warehouse.getChildren().add(temp);
					boxList.add(temp);
				}
			}
		}

		for(int i=0;i<targets.length;i++){
			Circle c = new Circle(32*targets[i][1]+16,32*targets[i][0]+16,10.0);
			c.setFill(Color.RED);
			warehouse.getChildren().add(c);
		}
	}
	//找到箱子
	public ImageView findBox(int row,int col){
		Iterator<ImageView> it = boxList.iterator();
		while(it.hasNext()){
			ImageView temp = it.next();
			if((int)temp.getX()/32==col && (int)temp.getY()/32==row){
				return temp;
			}
		}
		return null;
	}

	//判断是否胜利
	public void isWin(){
		int winFlag=0;
		Iterator<ImageView> it = boxList.iterator();
		while(it.hasNext()){
			ImageView temp = it.next();
			for(int i=0;i<targets.length;i++){
				if((int)temp.getX()/32==targets[i][1] && (int)temp.getY()/32==targets[i][0]){
					winFlag++;
				}
			}
		}
		if(winFlag==3){
			Alert information = new Alert(Alert.AlertType.INFORMATION,"恭喜您取得了胜利");
			information.setHeaderText("胜利");
			information.show();
		}

	}


}