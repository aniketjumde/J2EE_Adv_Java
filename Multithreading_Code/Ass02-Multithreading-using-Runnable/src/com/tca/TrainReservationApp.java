package com.tca;
class TicketCounter 
{
    private int availableSeats;

    public TicketCounter(int seats) 
    {
        this.availableSeats = seats;
    }

    public synchronized void bookTicket(String passengerName, int seats) 
    {
        System.out.println(passengerName + " wants to book " + seats + " seat(s).");

        if (availableSeats >= seats) {
            System.out.println("✅ Seats available! Booking for " + passengerName + "...");
            try 
            {
                Thread.sleep(500);
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
            }
            availableSeats -= seats;
            System.out.println(passengerName + " successfully booked " + seats + " seat(s).");
            System.out.println("Remaining seats: " + availableSeats);
        } else {
            System.out.println("Sorry " + passengerName + ", only " + availableSeats + " seat(s) left. Booking failed.");
        }
        System.out.println("----------------------------------");
    }
}

class Passenger implements Runnable {
    private TicketCounter counter;
    private String passengerName;
    private int seatsToBook;

    public Passenger(TicketCounter counter, String passengerName, int seatsToBook) {
        this.counter = counter;
        this.passengerName = passengerName;
        this.seatsToBook = seatsToBook;
    }

    @Override
    public void run() {
        counter.bookTicket(passengerName, seatsToBook);
    }
}

public class TrainReservationApp {
    public static void main(String[] args) {
        TicketCounter counter = new TicketCounter(5);
        
        Thread t1 = new Thread(new Passenger(counter, "Aniket", 2));
        Thread t2 = new Thread(new Passenger(counter, "Priya", 1));
        Thread t3 = new Thread(new Passenger(counter, "Amit", 3));
        Thread t4 = new Thread(new Passenger(counter, "Sara", 2));

        t1.start();
        t2.start();
        t3.start();
        t4.start();
    }
}