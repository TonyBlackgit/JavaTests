package com.IDEA.example;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

/**
 * 空调 － 状态转移表模式
 *
 */
public class ActionTable {
    /**
     * 状态转移表
     */
    private List<Transfor> transforTable = new ArrayList<Transfor>() {
        private static final long serialVersionUID = 2679742264102211454L;
        {
            add(Transfor.of( State.OFF,      Event.CLICK_POWER,  State.FAN_ONLY, () -> doStartFan() ));
            add(Transfor.of( State.FAN_ONLY, Event.CLICK_POWER,  State.OFF,      () -> doStopFan()  ));
            add(Transfor.of( State.FAN_ONLY, Event.CLICK_COOL,   State.COOL,     () -> doStartCool()));
            add(Transfor.of( State.COOL,     Event.CLICK_POWER,  State.OFF,      () -> doStopCool() ));
            add(Transfor.of( State.COOL,     Event.CLICK_COOL,   State.FAN_ONLY, () -> doStartFan() ));
        }
    };

    /**
     * 空调当前状态
     */
    private State currentState = State.OFF;

    public void dispather(Event event) {
        transforTable.forEach(transfor -> {
            if(transfor.startState == currentState && transfor.event == event){
                if(Objects.nonNull(transfor.doAction)){
                    transfor.doAction.run();
                    setCurrentState(transfor.nextState);
                }
            }
        });
    }

    private void doStartFan() {
        System.out.println("start Fan");
    }

    private void doStopFan() {
        System.out.println("stop Fan");
    }

    private void doStartCool() {
        System.out.println("start Cool");
    }

    private void doStopCool() {
        System.out.println("stop Cool");
    }

    private void setCurrentState(State currentState) {
        this.currentState = currentState;
    }
    /**
     * 转移
     */
    static class Transfor {
        //开始状态
        State startState;
        //事件
        Event event;
        //目标状态
        State nextState;
        //执行动作
        Runnable doAction;

        static Transfor of(State startState, Event event, State nextState, Runnable doAction) {
            Transfor transfor = new Transfor();
            transfor.startState = startState;
            transfor.nextState = nextState;
            transfor.event = event;
            transfor.doAction = doAction;
            return transfor;
        }
    }

    /**
     * 空调状态枚举
     */
    public enum State {
        //关闭中状态
        OFF,
        //送风中状态
        FAN_ONLY,
        //制冷中状态
        COOL
    }

    /**
     * 空调事件枚举
     */
    public enum Event {
        //点击电源键
        CLICK_POWER,
        //点击制冷键
        CLICK_COOL
    }
}

