
public class GAPI {
	
	
	enum API {
		SET_USERNAME("set_username"),
        ON_GAME_START("game_start");
		
		final String command;
		
		API(String command) {
			this.command = command;
		}

	}
	
	/**
	 * 
LOGIN("set_username"),
"play"
"join_1v1"
"join_private"
"join_team"
"set_custom_team"
LEAVE_GAME_LOBBY("cancel")
"set_force_start"
"set_force_start"
"set_force_start"
"set_force_start"
"clear_moves"
"attack"
"ping_tile"
"chat_message"
"leave_game"
"stars_and_rank"
"cancel"
        leaveNonFreeForAllQueue(gameId);
        leaveNonFreeForAllQueue(ONE_VS_ONE_QUEUE);
        leaveNonFreeForAllQueue(TWO_VS_TWO_QUEUE


return onEvent("connect", (args) -> listener.onEvent());
return onEvent("connect", (args) -> listener.onEvent(), true);
return onEvent("disconnect", (args) -> listener.onEvent());
return onEvent("game_start", (args) -> listener.onEvent(objectMapper.convertValue(args[0], GameStartApiResponse.class)));
return onEvent("game_update", (args) -> listener.onEvent(objectMapper.convertValue(args[0], GameUpdateApiResponse.class)));
return onEvent("game_lost", (args) -> listener.onEvent(objectMapper.convertValue(args[0], GameLostApiResponse.class)));
return onEvent("game_won", (args) -> listener.onEvent());
return onEvent("chat_message", (args) -> listener.onEvent((
return onEvent("rank", (args) -> listener.onEvent(objectMapper.convertValue(args[0], RanksApiResponse.class)));
return onEvent("stars", (args) -> listener.onEvent(objectMapper.convertValue(args[0], StarsApiResponse.class)));
return onEvent("error_set_username", (args) -> {
	
	 */
	
	
	
	
	/*
    private static final String ONE_VS_ONE_QUEUE = "1v1";
    private static final String TWO_VS_TWO_QUEUE = "2v2";
    private static final String FFA_QUEUE = "";
    private static final Logger LOGGER = LoggerFactory.getLogger(GeneralsApi.class);
    private Socket socket;

    private static ObjectMapper objectMapper = new ObjectMapper();

    static {
        objectMapper.registerModule(new JsonOrgModule());
        objectMapper.disable(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES);
    }

    private GeneralsApi(Socket socket) {
        this.socket = socket;

    }

    public static GeneralsApi create() {
        return new GeneralsApi(new RealSocket());
    }
    */

    /**
     * For testing purposes.
     */
	/*
    public static GeneralsApi createWithCustomSocket(Socket socket) {
        return new GeneralsApi(socket);
    }

    public boolean isConnected() {
        return socket.connected();
    }

    /* LISTENERS */
	
	/*

    public GeneralsApi onEvent(String event, Consumer<Object[]> listener, boolean onlyOnce) {
        Consumer<Object[]> socketListener = args -> {
            LOGGER.trace("Received {}: {}", event, Arrays.toString(args));
            listener.accept(args);
        };
        if (onlyOnce) {
            socket.once(event, socketListener);
        } else {
            socket.on(event, socketListener);
        }
        return this;
    }

    public GeneralsApi onEvent(String event, Consumer<Object[]> listener) {
        return onEvent(event, listener, false);
    }


    public GeneralsApi onConnected(NoArgsListener listener) {
        return onEvent("connect", (args) -> listener.onEvent());
    }

    public GeneralsApi onceConnected(NoArgsListener listener) {
        return onEvent("connect", (args) -> listener.onEvent(), true);
    }

    public GeneralsApi onDisconnected(NoArgsListener listener) {
        return onEvent("disconnect", (args) -> listener.onEvent());
    }

    public GeneralsApi onGameStarted(OneArgListener<GameStartApiResponse> listener) {
        return onEvent("game_start", (args) -> listener.onEvent(objectMapper.convertValue(args[0], GameStartApiResponse.class)));
    }

    public GeneralsApi onGameUpdated(OneArgListener<GameUpdateApiResponse> listener) {
        return onEvent("game_update", (args) -> listener.onEvent(objectMapper.convertValue(args[0], GameUpdateApiResponse.class)));
    }

    public GeneralsApi onGameLost(OneArgListener<GameLostApiResponse> listener) {
        return onEvent("game_lost", (args) -> listener.onEvent(objectMapper.convertValue(args[0], GameLostApiResponse.class)));
    }

    public GeneralsApi onGameWon(NoArgsListener listener) {
        return onEvent("game_won", (args) -> listener.onEvent());
    }

    public GeneralsApi onChatMessage(ChatMessageListener listener) {
        return onEvent("chat_message", (args) -> listener.onEvent((String) args[0], objectMapper.convertValue(args[1], ChatMessageApiResponse.class)));
    }

    public GeneralsApi onRanksReceived(OneArgListener<RanksApiResponse> listener) {
        return onEvent("rank", (args) -> listener.onEvent(objectMapper.convertValue(args[0], RanksApiResponse.class)));
    }

    public GeneralsApi onStarsReceived(OneArgListener<StarsApiResponse> listener) {
        return onEvent("stars", (args) -> listener.onEvent(objectMapper.convertValue(args[0], StarsApiResponse.class)));
    }

    public GeneralsApi onSetUsernameError(OneArgListener<String> listener) {
        return onEvent("error_set_username", (args) -> {
            if (args.length > 0 && ((String) args[0]).length() > 0) {
                listener.onEvent((String) args[0]);
            }
        });
    }

    */
    /* ACTIONS*/
    /*

    private void send(String event, Object... args) {
        LOGGER.trace("Sending {}: {}", event, Arrays.toString(args));
        socket.emit(event, args);
    }

    public void setUsername(String userId, String userName) {
        send("set_username", userId, userName);
    }

    public void joinCustomGameQueue(String userId, String gameId) {
        send("join_private", gameId, userId);
    }

    public void joinFreeForAllQueue(String userId) {
        send("play", userId);
    }

    public void joinOneVsOneQueue(String userId) {
        send("join_1v1", userId);
    }

    public void setTeamInCustomGame(String customGameId, int team) {
        send("set_custom_team", team);
    }

    public void joinTwoVsTwoQueue(String userId, String team) {
        send("join_team", team, userId);
    }

    public void leaveCustomGameQueue(String gameId) {
        leaveNonFreeForAllQueue(gameId);
    }

    public void leaveFreeForAllQueue() {
        send("cancel");
    }

    public void leaveOneVsOneQueue() {
        leaveNonFreeForAllQueue(ONE_VS_ONE_QUEUE);
    }

    public void leaveTwoVsTwoQueue() {
        leaveNonFreeForAllQueue(TWO_VS_TWO_QUEUE);
    }

    public void forceStartFreeForAllQueue(boolean forceStart) {
        send("set_force_start", FFA_QUEUE, forceStart);
    }

    public void forceStartOneVsOneQueue(boolean forceStart) {
        send("set_force_start", ONE_VS_ONE_QUEUE, forceStart);
    }

    public void forceStartTwoVsTwoQueue(boolean forceStart) {
        send("set_force_start", TWO_VS_TWO_QUEUE, forceStart);

    }

    public void forceStartCustomGameQueue(boolean forceStart, String gameId) {
        send("set_force_start", gameId, forceStart);

    }

    public void clearMoves() {
        send("clear_moves");
    }

    public void attack(int start, int end, boolean is50) {
        send("attack", start, end, is50);
    }

    public void ping(int index) {
        send("ping_tile", index);
    }

    public void sendChatMessage(String chatRoom, String text) {
        send("chat_message", chatRoom, text);
    }

    public void leaveGame() {
        send("leave_game");
    }

    public void requestStarsAndRank(String userId) {
        send("stars_and_rank", userId);
    }

    private void leaveNonFreeForAllQueue(String queueId) {
        send("cancel", queueId);
    }
    */

}
