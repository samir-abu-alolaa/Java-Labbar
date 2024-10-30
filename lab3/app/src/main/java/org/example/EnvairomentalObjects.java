package org.example;

abstract class EnvairomentalObjects implements GameObjects{
    private int x_position;
    private int y_position;
    private boolean movable = false;

    public EnvairomentalObjects(int x_position, int y_position){
        this.x_position = x_position;
        this.y_position = y_position;
    }

    @Override
    public int getX(){
        return this.x_position;
    }
    @Override
    public int getY(){
        return this.y_position;
    }
    @Override
    public boolean isMovable(){
        return this.movable;
    }
    @Override
    public void setX(int x){
        this.x_position = x;
    }
    @Override
    public void setY(int y){
        this.y_position = y;
    }
}
