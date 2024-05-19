package ua.javarush;

import org.telegram.telegrambots.bots.TelegramLongPollingBot;
import org.telegram.telegrambots.meta.TelegramBotsApi;
import org.telegram.telegrambots.meta.api.methods.send.SendMessage;
import org.telegram.telegrambots.meta.api.objects.Update;
import org.telegram.telegrambots.meta.exceptions.TelegramApiException;
import org.telegram.telegrambots.updatesreceivers.DefaultBotSession;



import static ua.javarush.TelegramBotUtils.createMessage;
import static ua.javarush.TelegramBotUtils.getChatId;

public class MyFirstTelegramBot extends TelegramLongPollingBot {
    @Override
    public String getBotUsername() {
        // TODO: додай ім'я бота в лапки нижче
        return "dogakitainu_bot";
    }

    @Override
    public String getBotToken() {
        // TODO: додай токен бота в лапки нижче
        return "7130212070:AAF5yPjYEpUGd-E_faRhH1iYc8KyiObArHI";
    }

    @Override
    public void onUpdateReceived(Update update) {
         Long chatId = getChatId(update);



         if (update.hasMessage() && update.getMessage().getText().equals("/start")) {
             String username = update.getMessage().getFrom().getUserName();

             SendMessage message = createMessage(chatId, " Привіт, майбутній програміст " + username);
        sendApiMethodAsync(message);
         }if (update.hasMessage() && update.getMessage().getText().contains("привіт")){
             SendMessage message = createMessage(chatId, "Привіт як тебе звати ?");
             sendApiMethodAsync(message);
         }
         if (update.hasMessage()&&update.getMessage().getText().contains("мене звуть")){
             SendMessage message = createMessage(chatId, "Радий знайомству, я — Кіт");
             sendApiMethodAsync(message);

         }


            }







    public static void main(String[] args) throws TelegramApiException {
        TelegramBotsApi telegramBotsApi = new TelegramBotsApi(DefaultBotSession.class);
        telegramBotsApi.registerBot(new MyFirstTelegramBot());

    }
}