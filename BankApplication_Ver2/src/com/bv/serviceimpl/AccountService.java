package com.bv.serviceimpl;

import java.util.Scanner;

import com.bv.model.Account;

public class AccountService {
	SavingAccountsRepository savingAccountsRepository;
	CurrentAccountRepository currentAccountRepository;
	SavingAccountService savingAccountService;
	CurrentAccountService currentAccountService;
	Account account;

	public AccountService() {
		super();
		this.account = account;
		/*if (account instanceof SavingAccount)
			savingAccountService = new SavingAccountService(account);
		else
			currentAccountService = new CurrentAccountService(account);
		*/
		savingAccountsRepository =new SavingAccountsRepository();
		currentAccountRepository = new CurrentAccountRepository();
	}

	public void chooseAccount() {
		Scanner sc = null;
		int choice;
		boolean flag = true;
		while (flag) {

			System.out.println("\n" + "Select one of the options below");
			System.out.println("1. Saving" + "\n" + "2. Current" + "\n");
			sc = new Scanner(System.in);
			choice = sc.nextInt();
			switch (choice) {
			case 1: {
				System.out.println("Enter the Account No.:");
				savingAccountService = new SavingAccountService(savingAccountsRepository.getAccount(sc.nextInt()));
				savingAccountService.chooseOperation();
				break;
			}

			case 2: {
				System.out.println("Enter the Account No.:");
				currentAccountService = new CurrentAccountService(currentAccountRepository.getAccount(sc.nextInt()));
				currentAccountService.chooseOperation();
				break;
			}
			default: {
				System.out.println("Enter Valid Account"+"\n");
				break;
			}
			}
		}
	}
}

/*SavingAccount savingAccount=new SavingAccount();
				System.out.println("Enter your Saving account number : "+"\n");
				savingAccount.setAcc_no(sc.nextInt());
				System.out.println("Enter your Name : "+"\n");
				System.out.println("Is your account is salary account : "+"\n"+"1. YES "+"\n2. NO"+"\n");
				int select=0;
				switch (select) {
				case 1: {savingAccount.settrue;
				}
				case 2: {
				}
				}*/