MAIN_DIR = src
TEST_DIR = test

.PHONY: main test

all: main test

main:
	$(MAKE) -C $(MAIN_DIR)

test:
	$(MAKE) -C $(TEST_DIR)
	@echo [{\"className\":\"test_source\",\"methodName\":\"test_sum\",\"points\":[1, 2]}]

clean:
	rm -f tmc_available_points.txt tmc_test_results.xml valgrind.log mockoutput mockinput
	$(MAKE) -C $(MAIN_DIR) clean
	$(MAKE) -C $(TEST_DIR) clean

run-main:
	$(MAKE) -C $(MAIN_DIR) run

run-test:
	$(MAKE) -C $(TEST_DIR) run

run-test-with-valgrind:
	@echo Failed

get-points:
	$(MAKE) -C $(TEST_DIR) get-points