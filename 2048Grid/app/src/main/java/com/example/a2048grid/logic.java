package com.example.a2048grid;

import java.util.Random;

public class logic {
    private static int dim=4;
    private boolean moved=false;
    private int t=0;
    public static int grade=0;
    public void calculate(int grade){
        this.grade+=grade;
    }

    public void rand_L(Local[][] locals){
        Random random=new Random();
        int count=3;
        while (count<dim){
            int r=random.nextInt(dim);
            int c=random.nextInt(dim);
            int rand=random.nextInt(100);
            if(locals[r][c].getValue()==0){
                if(rand>=0&&rand<=20)
                    locals[r][c].setValue(4);
                else
                    locals[r][c].setValue(2);
                count++;
            }
        }
    }
    public boolean move_up(Local[][] locals){
        moved=false;
        for(int r=0;r<dim-1;r++){
            for(int c=0;c<dim;c++){
                t=0;
                if(locals[r][c].getValue()==0){
                    t=r+1;
                    while (t<dim && locals[t][c].getValue()==0){
                        t+=1;
                    }
                    if(t!=dim && locals[t][c].getValue()!=0){
                        locals[r][c].setValue(locals[t][c].getValue());
                        locals[t][c].setValue(0);
                        moved=true;
                    }
                    else
                        continue;
                }
                if(t==0)
                    t=r+1;
                while (t<dim && locals[t][c].getValue()==0){
                    t+=1;
                }
                if(t!=dim && locals[r][c].getValue()==locals[t][c].getValue()){
                    locals[r][c].setValue(locals[r][c].getValue()+locals[r][c].getValue());
                    locals[t][c].setValue(0);
                    moved=true;
                    calculate(locals[r][c].getValue());
                }

            }
        }
        return moved;
    }
    public boolean move_down(Local[][] locals){
        moved=false;
        for(int r=3;r>0;r--){
            for(int c=0;c<dim;c++){
                t=0;
                if(locals[r][c].getValue()==0){
                    t=r-1;
                    while (t>=0 && locals[t][c].getValue()==0){
                        t-=1;
                    }
                    if(t>=0 && locals[t][c].getValue()!=0){
                        locals[r][c].setValue(locals[t][c].getValue());
                        locals[t][c].setValue(0);
                        moved=true;
                    }
                    else
                        continue;
                }
                if(t==0){
                    t=r-1;
                }
                while (t>=0 && locals[t][c].getValue()==0){
                    t-=1;
                }
                if(t>=0 && locals[r][c].getValue()==locals[t][c].getValue()){
                    locals[r][c].setValue(locals[r][c].getValue()+locals[r][c].getValue());
                    locals[t][c].setValue(0);
                    moved=true;
                    calculate(locals[r][c].getValue());
                }
            }
        }
        return moved;
    }
    public boolean move_right(Local[][] locals){
        moved=false;
        for(int r=0;r<dim;r++){
            for(int c=3;c>0;c--){
                t=0;
                if(locals[r][c].getValue()==0){
                    t=c-1;
                    while (t>=0 && locals[r][t].getValue()==0){
                        t-=1;
                    }
                    if(t>=0&& locals[r][t].getValue()!=0){
                        locals[r][c].setValue(locals[r][t].getValue());
                        locals[r][t].setValue(0);
                        moved=true;
                    }
                }
                if(t==0){
                    t=c-1;
                }
                while (t>=0&&locals[r][t].getValue()==0){
                    t-=1;
                }
                if(t>=0 && locals[r][c].getValue()==locals[r][t].getValue()){
                    locals[r][c].setValue(locals[r][c].getValue()+locals[r][c].getValue());
                    locals[r][t].setValue(0);
                    moved=true;
                    calculate(locals[r][c].getValue());
                }
            }
        }
        return moved;
    }
    public boolean move_left(Local[][] locals){
        moved=false;
        for(int r=0;r<dim;r++){
            for(int c=0;c<dim-1;c++){
                t=0;
                if(locals[r][c].getValue()==0){
                    t=c+1;
                    while (t<dim && locals[r][t].getValue()==0){
                        t+=1;
                    }
                    if(t<dim && locals[r][t].getValue()!=0){
                        locals[r][c].setValue(locals[r][t].getValue());
                        locals[r][t].setValue(0);
                        moved=true;
                    }
                }
                if(t==0){
                    t=c+1;
                }
                while (t<dim && locals[r][t].getValue()==0){
                    t+=1;
                }
                if(t<dim && locals[r][c].getValue()==locals[r][t].getValue()){
                    locals[r][c].setValue(locals[r][c].getValue()+locals[r][c].getValue());
                    locals[r][t].setValue(0);
                    moved=true;
                    calculate(locals[r][c].getValue());
                }
            }
        }
        return moved;
    }
}

