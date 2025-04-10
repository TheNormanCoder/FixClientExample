package com.example.fixclient;

import quickfix.*;
import quickfix.fix42.NewOrderSingle;
import quickfix.field.*;

public class FIXClient extends MessageCracker implements Application {

    @Override
    public void onCreate(SessionID sessionId) { }

    @Override
    public void onLogon(SessionID sessionId) {
        System.out.println("✅ Logon: " + sessionId);
        try {
            NewOrderSingle order = new NewOrderSingle(
                new ClOrdID("ORD123"),
                new HandlInst('1'),
                new Symbol("AAPL"),
                new Side(Side.BUY),
                new TransactTime(),
                new OrdType(OrdType.MARKET)
            );
            order.set(new OrderQty(100));
            Session.sendToTarget(order, sessionId);
            System.out.println("📤 Order sent: 100 AAPL BUY");
        } catch (SessionNotFound e) {
            e.printStackTrace();
        }
    }

    @Override
    public void onLogout(SessionID sessionId) {
        System.out.println("🚪 Logout: " + sessionId);
    }

    @Override
    public void toAdmin(Message message, SessionID sessionId) { }

    @Override
    public void toApp(Message message, SessionID sessionId) { }

    @Override
    public void fromAdmin(Message message, SessionID sessionId) { }

    @Override
    public void fromApp(Message message, SessionID sessionId) {
        System.out.println("📩 Received: " + message);
    }

    public static void main(String[] args) throws Exception {
        SessionSettings settings = new SessionSettings("fix.cfg");
        Application app = new FIXClient();
        MessageStoreFactory storeFactory = new FileStoreFactory(settings);
        LogFactory logFactory = new ScreenLogFactory(true, true, true);
        MessageFactory messageFactory = new DefaultMessageFactory();
        Initiator initiator = new SocketInitiator(app, storeFactory, settings, logFactory, messageFactory);
        initiator.start();
        System.out.println("🚀 FIX client started...");
        Thread.sleep(15000);
        initiator.stop();
        System.out.println("🛑 FIX client stopped.");
    }
}
