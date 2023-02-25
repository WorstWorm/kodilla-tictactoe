package com.tictactoe.ai;

import com.tictactoe.Field;

public record BestOption(int sloatsLacking, String direction, Field fieldOfStart) {
}
