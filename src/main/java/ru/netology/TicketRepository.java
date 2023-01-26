package ru.netology;

public class TicketRepository {
    private Ticket[] items = new Ticket[0];

    public Ticket[] findAll() {
        return items;
    }

    public Ticket findById(int id) {
        for (Ticket ticket : findAll()) {
            if (ticket.getId() == id) {
                return ticket;
            }
        }
        return null;
    }

    public void save(Ticket ticket) {
        int tmpId = ticket.getId();
        if (ticket == findById(tmpId)) {
            throw new AlreadyExistsException(
                    "Объект с данным ID уже добавлен: " + tmpId
            );
        }
        Ticket[] tmp = new Ticket[items.length + 1];
        for (int i = 0; i < items.length; i++) {
            tmp[i] = items[i];
        }
        tmp[tmp.length - 1] = ticket;
        items = tmp;
    }

    public void removeById(int id) {
        Ticket need = findById(id);
        if (need == null) {
            throw new NotFoundExeption("Объект с данным ID не найден: " + id);
        } else {
            Ticket[] tmp = new Ticket[items.length - 1];
            int copyToIndex = 0;
            for (Ticket item : items) {
                if (item.getId() != id) {
                    tmp[copyToIndex] = item;
                    copyToIndex++;
                }
            }
            items = tmp;
        }
    }
}
