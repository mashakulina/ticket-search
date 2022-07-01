package ru.netology;

import java.util.Objects;

public class Ticket implements Comparable<Ticket> {
    private int id;
    private int cost;
    private String airportFrom;
    private String airportTo;
    private int flightTime;

    public Ticket(int id, int cost, String airportFrom, String airportTo, int flightTime) {
        this.id = id;
        this.cost = cost;
        this.airportFrom = airportFrom;
        this.airportTo = airportTo;
        this.flightTime = flightTime;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getCost() {
        return cost;
    }

    public void setCost(int cost) {
        this.cost = cost;
    }

    public String getAirportFrom() {
        return airportFrom;
    }

    public void setAirportFrom(String airportFrom) {
        this.airportFrom = airportFrom;
    }

    public String getAirportTo() {
        return airportTo;
    }

    public void setAirportTo(String airportTo) {
        this.airportTo = airportTo;
    }

    public int getFlightTime() {
        return flightTime;
    }

    public void setFlightTime(int flightTime) {
        this.flightTime = flightTime;
    }

//    @Override
//    public String toString() {
//        return id;}

    @Override
    public int compareTo(Ticket otherTicket) {
        if (cost < otherTicket.cost) {
            return -1;
        }
        if (cost > otherTicket.cost) {
            return 1;
        }
        return 0;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Ticket ticket = (Ticket) o;
        return id == ticket.id && cost == ticket.cost && flightTime == ticket.flightTime && Objects.equals(airportFrom, ticket.airportFrom) && Objects.equals(airportTo, ticket.airportTo);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, cost, airportFrom, airportTo, flightTime);
    }
}
