package garage_exercise;

import java.time.LocalDateTime;

record RepairItem(String name, Double price, LocalDateTime createdAt) {}
