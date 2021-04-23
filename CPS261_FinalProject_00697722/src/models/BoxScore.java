//package models;
//
//import java.util.Date;
//
//public class BoxScore {
//    private Game game;
//    private String name;
//    private Date date;
//    private int finalScore;
//    private boolean winOrLose;
//
//    public BoxScore() {
//    }
//
//    public BoxScore(String name, Date date, int finalScore, boolean winOrLose) {
//	this.name = name;
//	this.date = date;
//	this.finalScore = finalScore;
//	this.winOrLose = winOrLose;
//    }
//
//    public String getName() {
//	return name;
//    }
//
//    public void setName(String name) {
//	this.name = name;
//    }
//
//    public Date getDate() {
//	return date;
//    }
//
//    public void setDate(Date date) {
//	this.date = date;
//    }
//
//    public int getFinalScore() {
//	return finalScore;
//    }
//
//    public void setFinalScore(int finalScore) {
//	this.finalScore = finalScore;
//    }
//
//    public boolean isWinOrLose() {
//	return winOrLose;
//    }
//
//    public void setWinOrLose(boolean winOrLose) {
//	this.winOrLose = winOrLose;
//    }
//
//    public void saveBoxScore() {
////	game.getPlayers().stream().
////	forEach(el->{
////	    el.getTotal();
////	});
//	game.getPlayers().forEach(el -> {
//	    setName(el.getName());
////	    setDate();
//	    setFinalScore(el.getTotal());
//	    // getWinOrLoss(); // have to add this computational method perhaps using lambda
//
//	});
//    }
//
//}
